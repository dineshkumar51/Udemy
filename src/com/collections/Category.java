package com.collections;

import java.util.*;

public class Category
{
        private String name;
        private LinkedHashMap<Integer,Topic> topics;

        public Category(String name) {
                this.name = name;
                this.topics = new LinkedHashMap<>();
        }

        public Topic getTopic(int id)
        {
                return topics.get(id);
        }


        public void addTopic(int id,String name)
        {
                topics.put(id,new Topic(name));

        }

        public void printTopics()
        {
                for(Map.Entry m : topics.entrySet()){
                        System.out.println(m.getKey()+". "+m.getValue());
                }
        }


        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }


        public String toString() {
                return name;
        }
}
