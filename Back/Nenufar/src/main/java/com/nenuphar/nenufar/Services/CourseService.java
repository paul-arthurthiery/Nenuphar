package com.nenuphar.nenufar.Services;

import com.nenuphar.nenufar.Models.Course;
import com.nenuphar.nenufar.Models.GradedSubSkill;
import com.nenuphar.nenufar.Models.Skill;
import com.nenuphar.nenufar.Models.SubSkill;
import com.nenuphar.nenufar.Repositories.CourseRepository;
import com.nenuphar.nenufar.Repositories.SkillRepository;
import com.nenuphar.nenufar.Repositories.SubSkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private SkillService skillService;
    @Autowired
    private SubSkillService subSkillService;
    @Autowired
    private GradedSubSkillService gradedSubSkillService;

    public Course getCourse(Long id)
    {
        Course temp = courseRepository.findOne(id);
        return infiniteLoopFix(temp);
    }

    public Course getPostedCourse(Course course){ return course;}

    public Course createCourse(String name, int nbrSkills)
    {
        Course course = new Course(name, nbrSkills);
        courseRepository.save(course);
        return course;
    }

    public List<Course> getCoursesFromUUID(String uuid)
    {
        try
        {
            List<Course> courses = courseRepository.getCoursesFromUUID(uuid);
            return infiniteListProcess(courses);
        }
        catch(Exception e)
        {
            return null;
        }
    }

    public ArrayList<Object> getAllAboutSkillsFromIDUuid(long course_id, String uuid)
    {
        List<Skill> skills = skillService.getSkillsFromCourseID(course_id);
        ArrayList<List<SubSkill>> subskills = new ArrayList<>();
        for(int i=0; i<skills.size(); i++)
        {
            List<SubSkill> subskill = subSkillService.getSubSkillsFromSkillID(skills.get(i).getId());
            subskills.add(subskill);
        }
        ArrayList<ArrayList<GradedSubSkill>> gradedsubskills = new ArrayList<>();
        for(int j=0; j<subskills.size(); j++)
        {
            ArrayList<GradedSubSkill> temp = new ArrayList<>();
            for(int k=0; k<subskills.get(j).size(); k++)
            {
                GradedSubSkill gradedsubskill = gradedSubSkillService.getGradedSubSkillFromSubskillUuid(subskills.get(j).get(k).getId(),uuid);
                temp.add(gradedsubskill);
            }
            gradedsubskills.add(temp);
        }
        ArrayList<Object> result = new ArrayList<>();
        result.add(skills);
        result.add(subskills);
        result.add(gradedsubskills);
        return result;
    }




    private Course infiniteLoopFix(Course temp)
    {
        Course course = new Course();
        course.setId(temp.getId());
        course.setManager(temp.getManagerID().getId());
        course.setName(temp.getName());
        course.setNbrSkills(temp.getNbrSkills());
        //course.setUsers(temp.getUsers());
        return course;
    }

    private List<Course> infiniteListProcess(List<Course> courses)
    {
        for(int i=0; i<courses.size(); i++)
        {
            Course temp = courses.get(i);
            Course course = infiniteLoopFix(temp);
            courses.set(i, course);
        }
        return courses;
    }

}
