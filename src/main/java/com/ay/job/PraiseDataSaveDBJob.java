package com.ay.job;

import com.ay.model.Mood;
import com.ay.model.UserMoodPraiseRel;
import com.ay.service.MoodService;
import com.ay.service.UserMoodPraiseRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Set;

@Component
@Configurable
@EnableScheduling
public class PraiseDataSaveDBJob {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserMoodPraiseRelService userMoodPraiseRelService;

    @Autowired
    private MoodService moodService;

    private static final String PRAISE_HASH_KEY = "springmvc.mybatis.boot.mood.id.list.key";

    @Scheduled(cron = "*/10 * * * * * ")
    public void savePraiseDataToDB2() {
        Set<String> moods = redisTemplate.opsForSet().members(PRAISE_HASH_KEY);
        if (CollectionUtils.isEmpty(moods)) {
            return;
        }
        for (String moodId : moods) {
            if (redisTemplate.opsForSet().members(moodId) == null) {
                continue;
            } else {
                Set<String> userIds = redisTemplate.opsForSet().members(moodId);
                if (CollectionUtils.isEmpty(userIds)) {
                    continue;
                } else {
                    for (String userId : userIds) {
                        UserMoodPraiseRel userMoodPraiseRel = new UserMoodPraiseRel();
                        userMoodPraiseRel.setMoodId(moodId);
                        userMoodPraiseRel.setUserId(userId);
                        userMoodPraiseRelService.save(userMoodPraiseRel);
                    }
                    Mood mood = moodService.findById(moodId);
                    mood.setPraiseNum(mood.getPraiseNum() + redisTemplate.opsForSet().size(moodId).intValue());
                    moodService.update(mood);
                    redisTemplate.delete(moodId);
                }
            }
        }
        redisTemplate.delete(PRAISE_HASH_KEY);
    }
}
