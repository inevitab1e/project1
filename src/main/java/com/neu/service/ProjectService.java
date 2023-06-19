package com.neu.service;

import com.neu.common.utils.UUIDUtil;
import com.neu.dao.ProjectEntityMapper;
import com.neu.dao.entity.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectEntityMapper projectEntityMapper;

    public List<ProjectEntity> queryProjectList(ProjectEntity projectEntity) {
        List<ProjectEntity> projectEntityList = projectEntityMapper.queryProjectList(projectEntity);
        return projectEntityList;
    }

    public int addProjectInfo(ProjectEntity projectEntity) {
        projectEntity.setId(UUIDUtil.getOneUUID());
        projectEntity.setCreationDate(new Date());
        projectEntity.setLastUpdateDate(new Date());
        int projectResult = projectEntityMapper.insert(projectEntity);
        if (projectResult == 0) {
            return 0;//数字0代表项目不存在
        } else {
            return projectResult;
        }
    }

    public int modifyProjectInfo(ProjectEntity projectEntity) {
        projectEntity.setLastUpdateDate(new Date());
        int projectResult = projectEntityMapper.updateByPrimaryKeySelective(projectEntity);
        return projectResult;
    }

    public int deleteProjectById(ProjectEntity projectEntity) {
        int projectResult = projectEntityMapper.deleteProjectById(projectEntity);
        return projectResult;
    }

    public List<ProjectEntity> selectProjectInfo(ProjectEntity projectEntity) {
        List<ProjectEntity> result = projectEntityMapper.selectProjectInfo(projectEntity);
        return result;
    }
}
