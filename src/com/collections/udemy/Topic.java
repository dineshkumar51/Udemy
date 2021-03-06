package com.collections.udemy;


import java.util.HashMap;
import java.util.Map;
import com.collections.users.Creator;


public class Topic

{

    private final String name;
    private final HashMap<Integer, Course> courses;


    public Topic(String name) {
        this.name = name;
        this.courses = new HashMap<>();
    }

    public String getName() {
        return name;
    }

   public Course addCourse(String name, Creator creator, int topicId, int categoryId)
    {
        Course newCourse = new Course(name,creator,topicId,categoryId);
        int courseId = newCourse.getId();
        courses.put(courseId,newCourse);
        return newCourse;
    }

    public void removeCourse(Course course)
    {
        courses.remove(course);
    }

    public Course addCourse(Course course,int courseId)
    {
        courses.put(courseId,course);
        return course;
    }



    public void printCourses()
    {
        System.out.println("COURSES");
        for(Map.Entry m : courses.entrySet())
        {

            Course course = (Course) m.getValue();
            if(course.getRating() >= 4.5f)
            {
                System.out.println("        FEATURED COURSE !!!");
                System.out.println(m.getValue());
                System.out.println();
            }

        }

        courses.forEach((key, value) ->
        {
            Course course = (Course) value;
            if (course.getRating() < 4.5f)
            {
                System.out.println(value);
                System.out.println();
            }
        });

    }



    @Override
    public int hashCode() {
        return name.hashCode();
    }


    @Override
    public boolean equals(Object obj) {
        if(obj == this)
        {
            return true;
        }
        else if(!(obj instanceof Topic))
        {
            return false;
        }
        else
        {
            Topic topic = (Topic) obj;

            return topic.getName().equals(name);
        }
    }


    @Override
    public String toString() {
        return name;
    }
}
