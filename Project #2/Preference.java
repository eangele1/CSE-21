public class Preference {
	private int quiettime, music,read,chat;

	//constructor
	public Preference (int quiettime, int music , int read , int chat){
		if (quiettime >= 0 && quiettime <= 10)
			this.quiettime = quiettime;
		if (music >= 0 && music <= 10)
			this.music = music;

		if (read >= 0 && read <= 10)
			this.read = read;

		if (chat >= 0 && chat <= 10)
			this.chat = chat;
	}

	public int getQuietTime(){

		return quiettime;
	} public int getMusic(){

		return music;
	} public int getRead(){

		return read;
	} public int getChat(){

		return chat;
	}

	public int compare(Preference pref){ int a1 = Math.abs(this.getQuietTime() - pref.getQuietTime());

	int a2 = Math.abs(this.getMusic() - pref.getMusic());

	int a3 = Math.abs(this.getRead() - pref.getRead());

	int a4 = Math.abs(this.getChat() - pref.getChat());

	return a1+a2+a3+a4;
	}
}