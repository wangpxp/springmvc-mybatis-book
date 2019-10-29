package com.ay.controller;

import com.alibaba.druid.stat.TableStat;
import com.ay.dto.MoodDTO;
import com.ay.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/mood")
public class MoodController {
    @Autowired
    private MoodService moodService;

    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<MoodDTO> moodDTOList = moodService.findAll();
        model.addAttribute("moods", moodDTOList);
        return "mood";
    }

    @GetMapping("/{moodId}/praise")
    public String praise(Model model, @PathVariable("moodId") String moodId, @RequestParam("userId") String userId) {
        boolean isPraise = moodService.praiseMood(userId, moodId);
        List<MoodDTO> moodDTOList = moodService.findAll();
        model.addAttribute("moods", moodDTOList);
        model.addAttribute("isPraise", isPraise);
        return "mood";
    }
}
