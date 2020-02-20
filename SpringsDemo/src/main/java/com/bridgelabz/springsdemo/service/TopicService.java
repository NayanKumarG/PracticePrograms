/*
 * @author : Nayan Kumar g
 * purpose : service class for business logic 
 * 
 */
package com.bridgelabz.springsdemo.service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import com.bridgelabz.springsdemo.entity.Topic;

@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("Java" , "Core java" , "Core java description"),
			new Topic("Spring" , "Spring framework" , "Spring description")));
	
	/*
	 * returns topic
	 */
	public List<Topic> getTopics()
	{
		return topics;
	}

	/*
	 * get particular topic
	 */
	public Topic getTopic(String id) {
		return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}

	/*
	 * add new topic
	 */
	public void addTopic(Topic topic) {
		topics.add(topic);
		
	}

	/*
	 * update topic
	 */
	public void updateTopic(String id, Topic topic) {
		
		for(int i = 0 ; i<topics.size() ; i++)
		{
			Topic t = topics.get(i);
			if(t.getId().equals(id))
			{
				topics.set(i, topic);
				return;
			}
			
		}
		
	}

	/*
	 * delete topic 
	 */
	public void deleteTopic(String id) {
		
		topics.removeIf(t->t.getId().equals(id));
	
	}
}
