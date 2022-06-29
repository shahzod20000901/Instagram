package com.example.instagram.Profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.instagram.R;
import com.example.instagram.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

public class EditProfileFragment extends Fragment {


    private static final String TAG="EditProfileFragment";
    private ImageView mProfilePhoto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_editprofile, container, false);
        mProfilePhoto=(ImageView) view.findViewById(R.id.profile_photo);


        setProfileImage();

        // back arrow for navigating back to "Profile Activity"
        ImageView backArrow=(ImageView) view.findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });



        return view;
    }


    private void setProfileImage(){
        Log.d(TAG, "setProfileImage: setting profile image.");
        String imgURL="www.google.com/search?q=android+icon&sxsrf=ALiCzsZWATuSbwFVEawKrD7IcZlIctNFRg:1656439188739&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjZ6r7r3ND4AhUhx4sKHUM_BuwQ_AUoAXoECAEQAw&biw=1600&bih=757&dpr=1#imgrc=62wna493Ul0QLM";
        UniversalImageLoader.setImage(imgURL, mProfilePhoto, null, "https://");
    }
}
