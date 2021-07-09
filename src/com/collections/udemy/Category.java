package com.collections.udemy;

import java.util.LinkedHashMap;
import java.util.Map;


public class Category
{
        private String name;
        private final LinkedHashMap<Integer, Topic> topics;

        public Category(String name) {
                this.name = name;
                this.topics = new LinkedHashMap<>();
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }


        public Topic getTopic(int id)
        {
                Topic topic =  topics.get(id);
                if(topic == null)
                {
                        throw new NullPointerException();
                }
                return topic;
        }


        public void addTopic(int id,String name)
        {
                topics.put(id,new Topic(name));

        }

        public void printTopics()
        {
                System.out.println("TOPICS");
                for(Map.Entry m : topics.entrySet()){
                        System.out.println("            "+m.getKey()+". "+m.getValue());
                }
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
                else if(!(obj instanceof Category))
                {
                        return false;
                }
                else
                {
                        Category category = (Category) obj;

                        return category.getName().equals(name);
                }
        }

        @Override
        public String toString() {
                return name;
        }
}
