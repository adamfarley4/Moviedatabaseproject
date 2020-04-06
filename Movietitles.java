package com.CSCE247;

public class Movietitles {
    private String name;
    private String cost;
    private String showtimes;
    private String ratings;
    private String reviews;

    public Movietitles(String name, String cost, String showtimes, String ratings, String reviews) {
        this.name = name;
        this.cost = cost;
        this.showtimes = showtimes;
        this.ratings = ratings;
        this.reviews = reviews;
    }

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
    
    public String getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(String showtimes) {
		this.showtimes = showtimes;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}
}
