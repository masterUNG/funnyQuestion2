package thailand.soumbundit.jirawat.funnyquestion.utility;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import thailand.soumbundit.jirawat.funnyquestion.R;

public class ShowScoreAdapter extends RecyclerView.Adapter<ShowScoreAdapter.ShowScoreViewHolder> {

    private Context context;
    private ArrayList<String> languageStringArrayList, listentingStringArrayList,
            timeSetStringArrayList, praticeStringArrayList, warmUpStringArrayList;
    private LayoutInflater layoutInflater;


    public ShowScoreAdapter(Context context,
                            ArrayList<String> languageStringArrayList,
                            ArrayList<String> listentingStringArrayList,
                            ArrayList<String> timeSetStringArrayList,
                            ArrayList<String> praticeStringArrayList,
                            ArrayList<String> warmUpStringArrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.languageStringArrayList = languageStringArrayList;
        this.listentingStringArrayList = listentingStringArrayList;
        this.timeSetStringArrayList = timeSetStringArrayList;
        this.praticeStringArrayList = praticeStringArrayList;
        this.warmUpStringArrayList = warmUpStringArrayList;
    }

    @Override
    public ShowScoreViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.recycler_show_score, parent, false);
        ShowScoreViewHolder showScoreViewHolder = new ShowScoreViewHolder(view);

        return showScoreViewHolder;
    }

    @Override
    public void onBindViewHolder(ShowScoreViewHolder holder, int position) {

        String language = languageStringArrayList.get(position);
        String listen = listentingStringArrayList.get(position);
        String timeSet = timeSetStringArrayList.get(position);
        String partice = praticeStringArrayList.get(position);
        String warmUp = warmUpStringArrayList.get((position));

        holder.languageTextView.setText(language);
        holder.listeningTextView.setText(listen);
        holder.timeSetingTextView.setText(timeSet);
        holder.praticeTextView.setText(partice);
        holder.warmUpTextView.setText(warmUp);

    }

    @Override
    public int getItemCount() {
        return timeSetStringArrayList.size();
    }

    public class ShowScoreViewHolder extends RecyclerView.ViewHolder {

        private TextView languageTextView, listeningTextView,
                timeSetingTextView, praticeTextView, warmUpTextView;


        public ShowScoreViewHolder(View itemView) {
            super(itemView);

            languageTextView = itemView.findViewById(R.id.txtLanguage);
            listeningTextView = itemView.findViewById(R.id.txtListening);
            timeSetingTextView = itemView.findViewById(R.id.txtTimeSet);
            praticeTextView = itemView.findViewById(R.id.txtPractice);
            warmUpTextView = itemView.findViewById(R.id.txtWarmUp);


        }
    }


}
