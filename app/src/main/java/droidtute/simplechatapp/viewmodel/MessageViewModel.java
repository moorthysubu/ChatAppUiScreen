package droidtute.simplechatapp.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import droidtute.simplechatapp.model.Message;

public class MessageViewModel extends AndroidViewModel {

    private MutableLiveData<List<Message>> conversationList;

    public MessageViewModel(@NonNull Application application) {
        super(application);
        conversationList= new MutableLiveData<>();
        conversationList.postValue(prepareDummyData());
    }


    private List<Message> prepareDummyData() {
        List<Message> messages = new ArrayList<>();
        messages.add(new Message("Emma Anderson","Hi,How are you?",2,"http://www.designskilz.com/random-users/images/imageF48.jpg","2 mins ago"));
        messages.add(new Message("John Adams","I went home at the time",6,"http://www.designskilz.com/random-users/images/imageM17.jpg","18 mins ago"));
        messages.add(new Message("Katie Howard","Sorry!. It's my mistaken",0,"http://www.designskilz.com/random-users/images/imageF24.jpg","24 mins ago"));
        messages.add(new Message("Taylor Robinson","Hey,You are the person I know dude",0,"http://www.designskilz.com/random-users/images/imageM51.jpg","1 hour ago"));
        messages.add(new Message("Michelle Cole","Chill!",0,"http://www.designskilz.com/random-users/images/imageF27.jpg","5 hour ago"));
        messages.add(new Message("Nathan Mitchell","Awesome",0,"http://www.designskilz.com/random-users/images/imageM24.jpg","20/07/2018"));
        messages.add(new Message("David Price","Even I am looking forward for the same",0,"http://www.designskilz.com/random-users/images/imageF50.jpg","18/07/2018"));
        messages.add(new Message("Eva Davies","Ohhh is it?",0,"http://www.designskilz.com/random-users/images/imageM12.jpg","17/07/2018"));
        messages.add(new Message("Anna Coleman","Yep. I want to let him know that's all.",0,"http://www.designskilz.com/random-users/images/imageF8.jpg","08/07/2018"));
        return messages;
    }

    public MutableLiveData<List<Message>> getConversationList() {
        return conversationList;
    }
}
