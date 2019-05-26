import java.util.*;

public class MinSetCoverage {
	
  public static class Clip
  {
    public int start, end;
    public Clip(int _s, int _t)
    {
      start = _s; end = _t;
    }
  }
    
	public static ArrayList<Clip> getMinSet(ArrayList<Clip> clips)
	{
		ArrayList<Clip> ret = new ArrayList<Clip>();
		Collections.sort(clips, new Comparator<Clip>(){
            public int compare(Clip c1, Clip c2){
            	return (c1.end == c2.end)? c2.start - c1.start
                		: c1.end - c2.end;
          }});
		
		Clip[] nonOverlap = new Clip[clips.size()];
		int numNonOverlap = 0;
		for (int i = 0; i < clips.size(); i++)
		{
			while (numNonOverlap > 0 && clips.get(i).start <= nonOverlap[numNonOverlap-1].start)
				numNonOverlap--;
			nonOverlap[numNonOverlap] = clips.get(i);
			numNonOverlap++;
		}
		
		int i = 0, j = 0;
		while (i < clips.size())
		{
			while (j+1 < numNonOverlap && nonOverlap[j+1].start < clips.get(i).end)
				j++;
			ret.add(nonOverlap[j]);
			while (i < clips.size() && clips.get(i) .start < nonOverlap[j].end)
				i++;
		}		
		return ret;
	}
	
	public static void main(String[] args) {
		Clip c1 = new Clip(2,4);
		Clip c2 = new Clip(3,7);
		Clip c3 = new Clip(1,8);
		ArrayList<Clip> input = new ArrayList<>();
		input.add(c1); input.add(c2); input.add(c3);
		ArrayList<Clip> ret = getMinSet(input);
	}

}
