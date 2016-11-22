package ly.generalassemb.drewmahrt.actorapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

/**
 * Created by charlie on 11/22/16.
 */

public class ActorRecyclerViewAdapter
        extends RecyclerView.Adapter<ActorRecyclerViewAdapter.ActorViewHolder> {

    private List<Actor> mActors;

    public ActorRecyclerViewAdapter(List<Actor> actors) {
        mActors = actors;
    }

    @Override
    public ActorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.actor_item, parent, false);
        return new ActorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ActorViewHolder holder, int position) {

        holder.mActorNameView.setText(String.format(Locale.getDefault(), "Name: %s",
                mActors.get(position).getName()));

        holder.mActorDOBView.setText(String.format(Locale.getDefault(), "DOB: %s",
                mActors.get(position).getDob()));

        holder.mNumOscarsView.setText(String.format(Locale.getDefault(), "Oscars won: %d",
                mActors.get(position).getNumOscars()));
    }

    @Override
    public int getItemCount() {
        return mActors.size();
    }

    public class ActorViewHolder extends RecyclerView.ViewHolder {

        TextView mActorNameView, mActorDOBView, mNumOscarsView;

        public ActorViewHolder(View itemView) {
            super(itemView);

            mActorNameView = (TextView) itemView.findViewById(R.id.actor_name);
            mActorDOBView = (TextView) itemView.findViewById(R.id.actor_dob);
            mNumOscarsView = (TextView) itemView.findViewById(R.id.num_oscars);
        }
    }
}
