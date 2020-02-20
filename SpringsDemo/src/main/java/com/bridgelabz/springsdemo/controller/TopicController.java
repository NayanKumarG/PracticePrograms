/*
 * @author : Nayan Kumar g
 * purpose : rest controller
 * 
 */
package com.bridgelabz.springsdemo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.springsdemo.entity.Topic;
import com.bridgelabz.springsdemo.service.TopicService;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	/*
	 * returns list of topics request by the user
	 */
	@RequestMapping("/topics")
	public List<Topic> getTopics()
	{
		return topicService.getTopics();
	}
	
	@RequestMapping("/msg")
	public String getMsg()
	{
		return "Welcome";
	}
	
	/*
	 * returns perticular topic
	 */
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id)
	{
		return topicService.getTopic(id);
	}
	
	/*
	 * create topic
	 */
	@RequestMapping(method=RequestMethod.POST , value="/topics")
	public void addTopic(@RequestBody Topic topic)
	{
		topicService.addTopic(topic);
	}
	
	/*
	 * update the topic
	 */
	@RequestMapping(method=RequestMethod.PUT , value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic , @PathVariable String id)
	{
	topicService.updateTopic(id, topic);
	}
	
	/*
	 * delete the topic
	 */
	@RequestMapping(method=RequestMethod.DELETE , value="/topics/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		topicService.deleteTopic(id);
	}

}
