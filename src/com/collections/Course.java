package com.collections;

public class Course implements Comparable
{
        private String name;
        private Creator creator;
        private float rating;
        private int numberOfUsers;


        public Course(String name, Creator creator) {
                this.name = name;
                this.creator = creator;
                this.rating = 0.0f;
                this.numberOfUsers = 0;
        }


        public int compareTo(Object o) {

                Course course = (Course) o;

                if(course.getRating() > rating)
                {
                        return 1;
                }
                else
                {
                        return -1;
                }

        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Creator getCreator() {
                return creator;
        }

        public void setCreator(Creator creator) {
                this.creator = creator;
        }

        public float getRating() {
                return rating;
        }

        public void setRating(float rating) {
                this.rating = rating;
        }

        public int getNumberOfUsers() {
                return numberOfUsers;
        }

        public void incrementNumberOfUsers() {
                this.numberOfUsers++;
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

                        return ((Course) obj).getName().equals(name);
                }
        }


        public String toString() {

                if(rating == 0.0f)
                {
                        return String.format(name + "\n"+"Instructor : "+creator.toString() + "\n" +"No of Students : " + numberOfUsers+"\n"+"Rating : Not yet rated");
                }
                else
                {
                        return String.format(name + "\n"+"Instructor : "+creator.toString() + "\n" +"No of Students : " + numberOfUsers+"\n"+"Rating : " + rating);

                }


        }
}
