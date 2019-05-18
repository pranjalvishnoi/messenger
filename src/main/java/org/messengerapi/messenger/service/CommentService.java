package org.messengerapi.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.messengerapi.messenger.db.DataBase;
import org.messengerapi.messenger.exception.DataNotFoundException;
import org.messengerapi.messenger.model.Comment;
import org.messengerapi.messenger.model.Message;

public class CommentService {


	private Map<Integer, Message> messages;
	//private Map<Integer, Message> profile=new HashMap<>();
	
	public CommentService()
	{
		messages=DataBase.getMessages();
	}
	
	public List<Comment> getAllComments(int msgId) {
		Map<Integer, Comment> comments=messages.get(msgId).getComments();
		List<Comment> list=new ArrayList<Comment>(comments.values());
		return list;
	}
	
	public Comment getComment(int mId, int cId)
	{
		Map<Integer, Comment> comments=messages.get(mId).getComments();
		Comment c=comments.get(cId);
	if(messages.get(mId)==null)
	{
		throw new DataNotFoundException("no message found for id "+mId);
	}
	else if(c==null)
	{
		throw new DataNotFoundException("no comment found for id "+cId);
	}
	else
		return c;
	}
	public Comment addComment(int mId,Comment comment)
	{	Map<Integer, Comment> comments=messages.get(mId).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(int mId, Comment comment)
	{
		Map<Integer, Comment> comments=messages.get(mId).getComments();
		if(comment.getId()<=0)
			return null;
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(int mId, int cId) {
		Map<Integer, Comment> comments=messages.get(mId).getComments();
		return comments.remove(cId);
		}
	
}
