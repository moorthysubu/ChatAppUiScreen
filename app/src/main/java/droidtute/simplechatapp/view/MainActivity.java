package droidtute.simplechatapp.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.RadioButton;

import java.util.List;

import droidtute.simplechatapp.R;
import droidtute.simplechatapp.adapter.MessageAdapter;
import droidtute.simplechatapp.common.Constants;
import droidtute.simplechatapp.model.Message;
import droidtute.simplechatapp.viewmodel.MessageViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private RecyclerView mRvConversationList;
    private MessageViewModel mMessageViewModel;
    private MessageAdapter mMessageAdapter;

    private CheckBox mCbIconFriends;
    private CheckBox mCbIconGroup;
    private CheckBox mCbIconLiked;

    private CheckBox mCbTextFriends;
    private CheckBox mCbTextGroup;
    private CheckBox mCbTextLiked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        bindActivity();
        initViewModel();
    }

    private void bindActivity() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_view_back);

        mCbIconFriends = findViewById(R.id.rb_friends);
        mCbIconGroup = findViewById(R.id.rb_group);
        mCbIconLiked = findViewById(R.id.rb_liked);

        mCbTextFriends = findViewById(R.id.cb_friends);
        mCbTextGroup = findViewById(R.id.cb_group);
        mCbTextLiked = findViewById(R.id.cb_liked);

        mRvConversationList = findViewById(R.id.rv_conversation);
        mRvConversationList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    private void initViewModel() {
        mMessageViewModel = ViewModelProviders.of(this).get(MessageViewModel.class);
        mMessageAdapter = new MessageAdapter(mMessageViewModel.getConversationList().getValue());
        mRvConversationList.setAdapter(mMessageAdapter);
        mMessageViewModel.getConversationList().observe(this, new Observer<List<Message>>() {
            @Override
            public void onChanged(@Nullable List<Message> messages) {
                mMessageAdapter.updateList(messages);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_friends:
                toggleStatus(Constants.MENU_TYPE_FRIENDS);
                break;
            case R.id.layout_group:
                toggleStatus(Constants.MENU_TYPE_GROUP);
                break;
            case R.id.layout_liked:
                toggleStatus(Constants.MENU_TYPE_LIKED);
                break;
            // icon click
            case R.id.rb_friends:
                toggleStatus(Constants.MENU_TYPE_FRIENDS);
                break;
            case R.id.rb_group:
                toggleStatus(Constants.MENU_TYPE_GROUP);
                break;
            case R.id.rb_liked:
                toggleStatus(Constants.MENU_TYPE_LIKED);
                break;

            // Text clicks
            case R.id.cb_friends:
                toggleStatus(Constants.MENU_TYPE_FRIENDS);
                break;
            case R.id.cb_group:
                toggleStatus(Constants.MENU_TYPE_GROUP);
                break;
            case R.id.cb_liked:
                toggleStatus(Constants.MENU_TYPE_LIKED);
                break;
        }
    }

    private void toggleStatus(int status) {
        switch (status) {
            case Constants.MENU_TYPE_FRIENDS:
                mCbIconFriends.setChecked(true);
                mCbIconGroup.setChecked(false);
                mCbIconLiked.setChecked(false);

                mCbTextFriends.setChecked(true);
                mCbTextGroup.setChecked(false);
                mCbTextLiked.setChecked(false);
                break;
            case Constants.MENU_TYPE_GROUP:

                mCbIconFriends.setChecked(false);
                mCbIconGroup.setChecked(true);
                mCbIconLiked.setChecked(false);

                mCbTextFriends.setChecked(false);
                mCbTextGroup.setChecked(true);
                mCbTextLiked.setChecked(false);
                break;
            case Constants.MENU_TYPE_LIKED:

                mCbIconFriends.setChecked(false);
                mCbIconGroup.setChecked(false);
                mCbIconLiked.setChecked(true);

                mCbTextFriends.setChecked(false);
                mCbTextGroup.setChecked(false);
                mCbTextLiked.setChecked(true);
                break;
        }
    }
}
