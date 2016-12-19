package me.appfriends.androidsample.sampleapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import me.appfriends.androidsample.R;
import me.appfriends.sdk.AppFriends;
import me.appfriends.ui.base.BaseFragment;
import me.appfriends.ui.models.UserModel;

/**
 * Created by Mike Dai Wang on 2016-11-02.
 */

public class EmptyFragment extends BaseFragment {
    private static final String TAG = EmptyFragment.class.getSimpleName();

    private ImageView userAvatar;
    private TextView userNameLabel;

    public static EmptyFragment createInstance() {
        return new EmptyFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_empty, container, false);

        userAvatar = (ImageView) view.findViewById(R.id.user_avatar);
        userNameLabel = (TextView) view.findViewById(R.id.user_name);
        Button logoutButton = (Button) view.findViewById(R.id.logout_button);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

        String currentUserID = AppFriends.getInstance().currentLoggedInUserId();
        UserModel currentUser = LocalUsersDatabase.sharedInstance().getUserWithID(currentUserID);
        userNameLabel.setText(currentUser.getName());
        if (currentUser.avatar != null) {
            Glide.with(getContext()).load(currentUser.getAvatar()).into(userAvatar);
        }

        return view;
    }

    private void logout() {
        AppFriends.getInstance().logout();
        getActivity().finish();
    }
}
