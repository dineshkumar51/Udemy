package com.collections.udemy;

import com.collections.exceptions.InvalidNumberException;
import com.collections.users.Creator;

public class Course
{

        private final int Id;
        private String name;
        private Creator creator;
        private int categoryId;
        private int topicId;
        private float rating;
        private int noOfRatings;
        private int numberOfUsers;
        private static int totalNoOfCourses;


        public Course(String name, Creator creator,int topicId,int categoryId) {
                this.name = name;
                this.creator = creator;
                this.rating = 0.0f;
                this.noOfRatings = 0;
                this.numberOfUsers = 0;
                this.topicId = topicId;
                this.categoryId = categoryId;
                this.Id = ++totalNoOfCourses;
        }


        public String getName()
        {
                return name;
        }

        public void setName(String name)
        {
                this.name = name;
        }

        public Creator getCreator()
        {
                return creator;
        }

        public void setCreator(Creator creator)
        {

                this.creator = creator;
        }

        public float getRating()
        {
                return rating;
        }

        public void setRating(float rating) throws InvalidNumberException
        {
                if(rating<0.0f || rating>5.0f)
                {
                        throw new InvalidNumberException("Invalid Number");
                }
                this.rating = ((this.rating * noOfRatings)+rating)/++noOfRatings;
        }

        public int getNumberOfUsers()
        {
                return numberOfUsers;
        }

        public void incrementNumberOfUsers()
        {
                this.numberOfUsers++;
        }

        public int getCategoryId()
        {
                return categoryId;
        }

        public void setCategoryId(int categoryId)
        {
                this.categoryId = categoryId;
        }

        public int getTopicId()
        {
                return topicId;
        }

        public void setTopicId(int topicId)
        {
                this.topicId = topicId;
        }

        @Override
        public int hashCode() {
                return name.hashCode();
        }

        @Override
       public boolean equals(Object obj)
        {
                if(obj == this)
                {
                        return true;
                }
                else if(!(obj instanceof Course course))
                {
                        return false;
                }
                else
                {
                        return course.getName().equals(name);
                }
        }

        @Override
        public String toString() {

                if(rating == 0.0f)
                {
                        return "\t\t"+"ID : "+Id+"\n\t\t"+name + "\n\t\t"+"Instructor : "+creator.toString() + "\n\t\t" +"No of Students : " + numberOfUsers+"\n\t\t"+"Rating : Not yet rated";
                }
                else
                {
                        String formattedRating = String.format("%.1f",rating);
                        return "\t\t"+"ID : "+Id+"\n\t\t"+name + "\n\t\t"+"Instructor : "+creator.toString() + "\n\t\t" +"No of Students : " + numberOfUsers+"\n\t\t"+"Rating : " + formattedRating;

                }


        }


        public int getId() {
                return Id;
        }


}
