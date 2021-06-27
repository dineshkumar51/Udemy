package com.collections;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;


public class Topic
{

    private String name;
    private LinkedList<Course> courses;


    public Topic(String name) {
        this.name = name;
        this.courses = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

   public Course addCourse(String name,Creator creator,int topicId,int categoryId)
    {
        Course newCourse = new Course(name,creator,topicId,categoryId);
        courses.add(newCourse);
        return newCourse;
    }

    public void removeCourse(Course course)
    {
        courses.remove(course);
    }

    public Course addCourse(Course course)
    {
        courses.addLast(course);
        return course;
    }

    public void UpdateCourses(Course course)
    {
        Course firstCourse = courses.getFirst();
        Course lastCourse = courses.getLast();

        if(course.getRating() >= firstCourse.getRating())
        {
            courses.addFirst(course);
            return;
        }

        if(course.getRating() <= lastCourse.getRating())
        {
            courses.addLast(course);
            return;
        }

        ListIterator itr = courses.listIterator();

        while(itr.hasNext())
        {
            Course currentCourse = (Course) itr.next();
            if(currentCourse.getRating() <= course.getRating())
            {
                itr.previous();
                itr.add(course);
                return;
            }

        }
    }

    public void printCourses()
    {
        Iterator<Course> itr = courses.iterator();
        System.out.println("COURSES");
        while(itr.hasNext())
        {
            Course course = itr.next();
            if(course.getRating() >= 4.5f)
            {
                System.out.println("        FEATURED COURSE !!!");
            }
            System.out.println(course);
            System.out.println("");
        }

    }



    public int hashCode() {
        return name.hashCode();
    }


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


    public String toString() {
        return name;
    }
}
