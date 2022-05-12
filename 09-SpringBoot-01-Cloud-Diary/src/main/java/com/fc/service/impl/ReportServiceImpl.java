package com.fc.service.impl;

import com.fc.dao.ReportDao;
import com.fc.entity.TbNote;
import com.fc.service.ReportService;
import com.fc.vo.NoteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ReportServiceImpl implements ReportService {
  @Autowired
  private ReportDao reportDao;

    @Override
    public Map<String, Object> getNoteCountByMonth(Integer id) {
Map<String,Object> data = null;
//根据id获取对象
List<NoteVO> notes = reportDao.getNoteCountByMonth(id);
if (notes!=null&&notes.size()>0){
  //创建两个对象进行接收将两个集合存入一个Map中，键分别为monthArray以及dataArray，用于存储月份和当前月日记总数。
  List<String> months = new ArrayList<>();
  List<Integer> noteCounts = new ArrayList<>();
  for (NoteVO note : notes) {
    //获取月份和数量
    months.add(note.getGroupName());
    noteCounts.add(note.getNoteCount());
  }
  //将两个集合存入一个Map中，键分别为monthArray以及dataArray，用于存储月份和当前月日记总数。
  data = new HashMap<>();

  data.put("monthArray", months);
  data.put("dataArray", noteCounts);
}

return data;
    }

  @Override
  public List<TbNote> getLocation(Integer id) {
    return reportDao.getLocation(id);
  }
}
