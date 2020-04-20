package com.cyc.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

import com.cyc.service.LaboratoryService;
import com.cyc.service.impl.LaboratoryServiceImpl;

public class NFDFlightDataTimerTask extends TimerTask{
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private LaboratoryService laboratoryService = new LaboratoryServiceImpl();
	
    @Override
    public void run() {
        try {
             //在这里写你要执行的内容
            System.out.println("执行当前时间"+formatter.format(Calendar.getInstance().getTime()));
            laboratoryService.autoAddLabatory();
        } catch (Exception e) {
            System.out.println("-------------解析信息发生异常--------------");
        }
    }

}
