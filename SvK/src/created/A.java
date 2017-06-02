package created;



import utils.InputReader;
import utils.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;

public class A {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.nextInt();

        Job []arr=new Job[n];
        for(int i=0;i<n;i++)arr[i]=new Job(in.nextInt(),in.nextInt());
        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.finish-o2.finish;
            }
        });
        //System.out.println(Arrays.toString(arr));
        out.println(printMaxActivities(arr,n));
    }
    static class Job{
        int start;int finish;

        @Override
        public String toString() {
            return "Job{" +
                    "start=" + start +
                    ", finish=" + finish +
                    '}';
        }

        public Job(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    int printMaxActivities(Job[]arr, int n)
    {int count=0;
        int i, j;

        i = 0;
        count++;
        // Consider rest of the activities
        for (j = 1; j < n; j++)
        {
            // If this activity has start time greater than or equal to the finish
            // time of previously selected activity, then select it
            if (arr[j].start >= arr[i].finish)
            {
                //System.out.println(j);
                count++;
                i = j;
            }
        }
        return count;
    }
}
