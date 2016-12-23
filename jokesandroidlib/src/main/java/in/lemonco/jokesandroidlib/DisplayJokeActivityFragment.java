package in.lemonco.jokesandroidlib;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DisplayJokeActivityFragment extends Fragment {

    public DisplayJokeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_display_joke, container, false);

        Intent intent = getActivity().getIntent();
        if(intent!=null){
            TextView textView = (TextView)view.findViewById(R.id.joke_text);
            textView.setText(intent.getStringExtra(DisplayJokeActivity.JOKE_TEXT));
        }

        return view;
    }
}
