
public class TestMovie4 {

	
	public static void printMovies(Movie2[] m){
		for(int i = 0; i < m.length; i++){
			System.out.println(m[i].toString());
		}
	}
	
	public static void sortYears(Movie2[] movies, int low, int high){
		if(low == high){
			return;
		}
		int mid = (low + high) / 2;
		
		sortYears(movies, low, mid);
		sortYears(movies, mid + 1, high);
		
		mergeYears(movies, low, mid, high);
		
	}
	
	public static void mergeYears(Movie2[] movies, int low, int mid, int high){
		Movie2[] temp = new Movie2[high - low + 1];
		
		int i = low;
		int j = mid + 1;
		int n = 0;
		
		while(i <= mid || j <= high){
			if(i > mid){
				temp[n] = movies[j];
				j++;
			}else if(j > high){
				temp[n] = movies[i];
				i++;
			}else if(movies[i].getMyYear() < movies[j].getMyYear()){
				temp[n] = movies[i];
				i++;
			}else{
				temp[n] = movies[j];
				j++;
			}
			n++;
		}
		
		for(int k = low; k <= high; k++){
			movies[k] = temp[k - low];
		}
	}
	
	public static void sortTitles(Movie2[] movies, int low, int high){
		if(low == high){
			return;
		}
		int mid = (low + high) / 2;
		
		sortTitles(movies, low, mid);
		sortTitles(movies, mid + 1, high);
		
		mergeTitles(movies, low, mid, high);
		
	}
	
	public static void mergeTitles(Movie2[] movies, int low, int mid, int high){
		Movie2[] temp = new Movie2[high - low + 1];
		
		int i = low;
		int j = mid + 1;
		int n = 0;
		
		while(i <= mid || j <= high){
			if(i > mid){
				temp[n] = movies[j];
				j++;
			}else if(j > high){
				temp[n] = movies[i];
				i++;
			}else if(movies[i].getMyTitle().compareTo(movies[j].getMyTitle()) > 0){
				temp[n] = movies[i];
				i++;
			}else{
				temp[n] = movies[j];
				j++;
			}
			n++;
		}
		
		for(int k = low; k <= high; k++){
			movies[k] = temp[k - low];
		}
	}
	
	public static void sortStudios(Movie2[] movies, int low, int high){
		if(low == high){
			return;
		}
		int mid = (low + high) / 2;
		
		sortStudios(movies, low, mid);
		sortStudios(movies, mid + 1, high);
		
		mergeStudios(movies, low, mid, high);
		
	}
	
	public static void mergeStudios(Movie2[] movies, int low, int mid, int high){
		Movie2[] temp = new Movie2[high - low + 1];
		
		int i = low;
		int j = mid + 1;
		int n = 0;
		
		while(i <= mid || j <= high){
			if(i > mid){
				temp[n] = movies[j];
				j++;
			}else if(j > high){
				temp[n] = movies[i];
				i++;
			}else if(movies[i].getMyStudio().compareTo(movies[j].getMyStudio()) < 0){
				temp[n] = movies[i];
				i++;
			}else{
				temp[n] = movies[j];
				j++;
			}
			n++;
		}
		
		for(int k = low; k <= high; k++){
			movies[k] = temp[k - low];
		}
	}
	
	public static void main(String[] args) {
		
		Movie2[] myMovies = new Movie2[10];
		
		myMovies[0] = new Movie2("The Muppets Take Manhattan", 2001, "Columbia Tristar");
		myMovies[1] = new Movie2("Mulan Special Edition", 2004, "Disney");
		myMovies[2] = new Movie2("Shrek 2", 2004, "Dreamworks");
		myMovies[3] = new Movie2("The Incredibles", 2004, "Pixar");
		myMovies[4] = new Movie2("Nanny McPhee", 2006, "Universal");
		myMovies[5] = new Movie2("The Curse of the Were-Rabbit", 2006, "Aardman");
		myMovies[6] = new Movie2("Ice Age", 2002, "20th Century Fox");
		myMovies[7] = new Movie2("Lilo & Stitch", 2002, "Disney");
		myMovies[8] = new Movie2("Robots", 2005, "20th Century Fox");
		myMovies[9] = new Movie2("Monsters, Inc.", 2001, "Pixar");

		System.out.println("Before Sorting:");
		printMovies(myMovies);
		
		System.out.println();
		System.out.println("Sorted by Year - Ascending:");
		sortYears(myMovies, 0, myMovies.length - 1);
		printMovies(myMovies);
		
		System.out.println();
		System.out.println("Sorted by Title - Descending:");
		sortTitles(myMovies, 0, myMovies.length - 1);
		printMovies(myMovies);

		System.out.println();
		System.out.println("Sorted by Studio - Ascending:");
		sortStudios(myMovies, 0, myMovies.length - 1);
		printMovies(myMovies);
	}

}
