package Java_Bootcamp.DSA.IntermediateToAdvance.GreedyAlgorithm.Medium;


import java.util.*;

class Meeting {
    int start, end, index;

    Meeting(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}

public class N_MeetingInOneRoom {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end =   {2, 4, 5, 7, 9, 9};
        int n = start.length;

        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i], i + 1));
        }

        // Sort by end time
        meetings.sort(Comparator.comparingInt(meeting -> meeting.end));

        List<Integer> answer = new ArrayList<>();
        int lastEnd = 0;

        for (Meeting m : meetings) {
            if (m.start >= lastEnd) {
                answer.add(m.index);
                lastEnd = m.end;
            }
        }

        System.out.println("Maximum number of meetings: " + answer.size());
        System.out.println("Order of meetings: " + answer);
    }
}
