package com.collections;

public class Course implements Comparable
{
        private String name;
        private Creator creator;
        private int categoryId;
        private int topicId;
        private float rating;
        private int noOfRatings;
        private int numberOfUsers;


        public Course(String name, Creator creator,int topicId,int categoryId) {
                this.name = name;
                this.creator = creator;
                this.rating = 0.0f;
                this.noOfRatings = 0;
                this.numberOfUsers = 0;
                this.topicId = topicId;
                this.categoryId = categoryId;
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
                        throw new InvalidNumberException();
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



       public int hashCode() {
                return name.hashCode();
        }


       public boolean equals(Object obj)
        {
                if(obj == this)
                {
                        return true;
                }
                else if(!(obj instanceof Course))
                {
                        return false;
                }
                else
                {
                        Course course = (Course) obj;

                        return course.getName().equals(name);
                }
        }


        public String toString() {

                if(rating == 0.0f)
                {
                        return String.format("\t\t"+name + "\n\t\t"+"Instructor : "+creator.toString() + "\n\t\t" +"No of Students : " + numberOfUsers+"\n\t\t"+"Rating : Not yet rated");
                }
                else
                {
                        String formattedRating = String.format("%.1f",rating);
                        return String.format("\t\t"+name + "\n\t\t"+"Instructor : "+creator.toString() + "\n\t\t" +"No of Students : " + numberOfUsers+"\n\t\t"+"Rating : " + formattedRating);

                }


        }


        public int compareTo(Object o) {

                Course course = (Course) o;



                if(course.getRating() > rating)
                {
                        return 1;
                }
                else if(course.getRating() > rating)
                {
                        return -1;
                }
                else
                {
                        return 0;
                }

        }

}
