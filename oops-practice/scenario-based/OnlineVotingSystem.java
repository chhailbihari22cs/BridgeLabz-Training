import java.util.*;

// Voter Class
class Voter {
    private String voterId;
    private String name;
    private boolean hasVoted;

    public Voter(String voterId, String name) {
        this.voterId = voterId;
        this.name = name;
        this.hasVoted = false;
    }

    public String getVoterId() {
        return voterId;
    }

    public String getName() {
        return name;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void setHasVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }
}

// Candidate Class
class Candidate {
    private String candidateId;
    private String name;
    private int votes;

    public Candidate(String candidateId, String name) {
        this.candidateId = candidateId;
        this.name = name;
        this.votes = 0;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return votes;
    }

    public void incrementVotes() {
        votes++;
    }
}

// Abstraction: Election Service
interface ElectionService {
    void registerVoter(String voterId, String name);

    void addCandidate(String candidateId, String name);

    void castVote(String voterId, String candidateId);

    void declareResults();
}

// Election Class
class Election implements ElectionService {
    private Map<String, Voter> voters = new HashMap<>();
    private Map<String, Candidate> candidates = new HashMap<>();

    @Override
    public void registerVoter(String voterId, String name) {
        if (voters.containsKey(voterId)) {
            System.out.println("Voter with ID " + voterId + " is already registered.");
        } else {
            voters.put(voterId, new Voter(voterId, name));
            System.out.println("Voter " + name + " registered successfully.");
        }
    }

    @Override
    public void addCandidate(String candidateId, String name) {
        if (candidates.containsKey(candidateId)) {
            System.out.println("Candidate with ID " + candidateId + " is already added.");
        } else {
            candidates.put(candidateId, new Candidate(candidateId, name));
            System.out.println("Candidate " + name + " added successfully.");
        }
    }

    @Override
    public void castVote(String voterId, String candidateId) {
        Voter voter = voters.get(voterId);
        Candidate candidate = candidates.get(candidateId);

        if (voter == null) {
            System.out.println("Voter with ID " + voterId + " is not registered.");
        } else if (candidate == null) {
            System.out.println("Candidate with ID " + candidateId + " is not found.");
        } else if (voter.hasVoted()) {
            System.out.println("Voter " + voter.getName() + " has already cast their vote.");
        } else {
            voter.setHasVoted(true);
            candidate.incrementVotes();
            System.out.println("Vote cast successfully for candidate " + candidate.getName() + " by voter "
                    + voter.getName() + ".");
        }
    }

    @Override
    public void declareResults() {
        System.out.println("Election Results:");
        candidates.values().stream()
                .sorted((c1, c2) -> Integer.compare(c2.getVotes(), c1.getVotes()))
                .forEach(candidate -> System.out.println(candidate.getName() + ": " + candidate.getVotes() + " votes"));
    }
}

// Main Class
public class OnlineVotingSystem {
    public static void main(String[] args) {
        Election election = new Election();

        // Register voters
        election.registerVoter("V001", "Alice");
        election.registerVoter("V002", "Bob");

        // Add candidates
        election.addCandidate("C001", "John");
        election.addCandidate("C002", "Emma");

        // Cast votes
        election.castVote("V001", "C001");
        election.castVote("V002", "C002");
        election.castVote("V001", "C002"); // Attempt to vote again

        // Declare results
        election.declareResults();
    }
}