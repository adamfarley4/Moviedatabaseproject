package com.CSCE247;

public class Theaternames {
    private String name;
    private int[][] seats;

    public Theaternames(String name) {
        this.name = name;
        this.seats = new int[5][5];
        for(int i=0;i<seats.length;i++) 
        	for(int j=0;j<seats.length;j++) 
        		seats[i][j] = j;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void printSeats() {
    	for(int i=0;i<seats.length;i++) {
    		System.out.println(" ");
        	for(int j=0;j<seats.length;j++) { 
        		System.out.print(seats[i][j]+1);
        		switch(i) {
        		case 0: System.out.print("a");
        		break;
        		case 1: System.out.print("b");
        		break;
        		case 2: System.out.print("c");
        		break;
        		case 3: System.out.print("d");
        		break;
        		case 4: System.out.print("e");
        		break;
        		}
        		System.out.print(" ");
        	}
    	}
    }
}

