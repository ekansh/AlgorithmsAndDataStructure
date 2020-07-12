package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Stream;

class FindCategoryOfMostUsedProductIs {
	public static void main(String[] args) {
		HashMap<String,List<String>> res= new HashMap<>();
		HashMap<String,List<String>> userSongs  = new HashMap<>();
		userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
		userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));
		
		
		HashMap<String,List<String>> songGenres   = new HashMap<>();
		songGenres .put("Rock", Arrays.asList("song1", "song3"));
		songGenres .put("Dubstep", Arrays.asList("song7"));
		songGenres .put("Techno", Arrays.asList("song2", "song4"));
		songGenres .put("Pop", Arrays.asList("song5", "song6"));
		songGenres .put("Jazz", Arrays.asList("song8", "song9"));
		
		
		HashMap<String,String> genre   = new HashMap<>();
		
		for (String gen : songGenres.keySet()) {
			List<String> list = songGenres.get(gen);
			for (String song : list) {
				genre.put(song, gen);
			}
		}
		
		
		HashMap<String,HashMap<String,Integer>>  tracks= new HashMap<>();
		for (String user : userSongs.keySet()) {
			List<String> list = userSongs.get(user);
			HashMap<String,Integer> map= new HashMap<String,Integer>( );
			tracks.putIfAbsent(user, map);
			int count =0;
			ArrayList<String> arrayList = new ArrayList< >();
			for (String s : list) {
				String thisSongGenre = genre.get(s);
				Integer integer = map.get(thisSongGenre);
				if ( integer== null) {
					map.put(thisSongGenre, 1);
					
				}else {
					map.put(thisSongGenre, map.get(thisSongGenre)+1);
				}
				if(count==map.get(thisSongGenre)) {
					arrayList.add(thisSongGenre);
				}else if (count <map.get(thisSongGenre)) {
					count =map.get(thisSongGenre);
					arrayList.clear();
					arrayList.add(thisSongGenre);
					
				}
			}
			res.put(user, arrayList);
		}
		
		
		
		res.keySet().stream().forEach(e->System.out.println(e+":"+res.get(e)));
		
		System.out.println();
		
		
	}
			

}