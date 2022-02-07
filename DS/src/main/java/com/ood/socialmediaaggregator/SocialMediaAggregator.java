package com.ood.socialmediaaggregator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SocialMediaAggregator {

	interface Post {
		int postId=0;
		String user = "";
		String text = "";
	}
	
	class Platform {

		private int id;

		private List<Post> currentFeeds;

		private Set<User> users;

		private List<Post> posts;

		private SocialMediaRule rule;

		public Boolean addUser(User user) {
			return this.users.add(user);
		}

		public Boolean removeUser(User user) {
			return this.users.remove(user);
		}

		public int getId() {
			return id;
		}

		public List<Post> getCurrentFeeds() {
			return currentFeeds;
		}

		public void addPost(Post post) {
			this.posts.add(post);
		}

		public void addPosts(List<Post> posts) {
			this.posts.addAll(posts);
		}

		public List<Post> applyRule(Post post) {
			return rule.process(post);
		}
	}

	class User {

		private int id;

		private Post postToShare;

		private List<Post> posts;

		private Set<Platform> platforms;

		private List<Post> feeds;

		public List<Post> getFeeds() {
			return feeds;
		}

		public void addPlatform(Platform platform) {
			this.platforms.add(platform);
		}

		public void removePlatform(Platform platform) {
			this.platforms.remove(platform);
		}

		public void addFeeds(List<Post> feeds) {
			this.feeds.addAll(feeds);
		}

		public void sharePost() {
			this.posts.add(postToShare);
		}

		public Post getPostToShare() {
			return postToShare;
		}
	}

	class Aggregator {

		final private User user;

		public Aggregator(User user) {
			this.user = user;
		}

		// AC 1, 3
		public void sharePostOnMultiplePlatforms(List<Platform> platforms) {
			for (Platform platform : platforms) {
				// AC 2
				this.user.sharePost();
				List<Post> posts = platform.applyRule(this.user.getPostToShare());
				platform.addPosts(posts);
			}
		}

		// AC 4
		public void addPlatform(Platform platform) {
			platform.addUser(user);
			this.user.addPlatform(platform);
		}

		// AC 4
		public void removePlatform(Platform platform) {
			platform.removeUser(user);
			this.user.removePlatform(platform);
		}

		// AC 5
		public List<Post> getFeeds(Platform platform) {
			List<Post> platformFeeds = platform.getCurrentFeeds();
			user.addFeeds(platformFeeds);
			return platformFeeds;
		}
	}

	interface SocialMediaRule {
		List<Post> process(Post post);
	}

	class TwitterRule implements SocialMediaRule {
		@Override
		public List<Post> process(Post post) {
			// todo: if post word count is more than 140, we create multiple posts base on
			// the original post

			return new ArrayList<>();
		}
	}
}