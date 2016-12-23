package com.example;

public class Jokes {
    private String[] jokes = {"Why did the physics teacher break up with the biology teacher? There was no chemistry",
            "Daddy did you know that girls are smarter than boys?\nNo, I didn’t know that.\nThere you go.\n",
            "Why does it suck to be a penguin?\nBecause even when you get angry, you still look cute.",
            "What did one ocean say to the other ocean? Nothing, they just waved.",
            "Born free, taxed to death.",
            "For Sale: Parachute. Only used once, never opened.",
            "What is faster Hot or cold? Hot, because you can catch a cold.",
            "What’s the difference between a new husband and a new dog? After a year, the dog is still excited to see you.",
            "Love may be blind, but marriage is a real eye-opener.",
            "Having sex is like playing bridge. If you don’t have a good partner, you’d better have a good hand.",
            "When everything’s coming your way, you’re in the wrong lane.",
            "Why did the bee get married? Because he found his honey.",
            "Time is what keeps things from happening all at once.",
            "When tempted to fight fire with fire, remember that the Fire Department usually uses water.",
            "A day without sunshine is like, night.",
            "As long as there are tests, there will be prayer in schools.",
            "A computer once beat me at chess, but it was no match for me at kick boxing.",
            "Why do men find it difficult to make eye contact? Breasts don’t have eyes.",
            "A bank is a place that will lend you money, if you can prove that you don’t need it.",
            "Why did the scientist install a knocker on his door? He wanted to win the No-bell prize!",
            "I say no to alcohol, it just doesn’t listen."
    };

    public String getJoke() {
        int random_joke = (int) ((Math.random()) * jokes.length);
        return jokes[random_joke];
    }
}
