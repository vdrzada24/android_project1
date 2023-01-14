package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import io.realm.Realm;
import io.realm.RealmResults;

public class Noteadap extends RecyclerView.Adapter<Noteadap.ViewHolder> {


    Context context;
    RealmResults<Note> notelist;
    public Noteadap(Context context,RealmResults<Note> notelist){
        this.context=context;
        this.notelist=notelist;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.note,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note=notelist.get(position);
        holder.title.setText(note.getTitle());
        holder.content.setText(note.getContent());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu menu=new PopupMenu(context,view);
                menu.getMenu().add("delete");
                menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if(menuItem.getTitle().equals("delete")){
                            Realm realm=Realm.getDefaultInstance();
                            realm.beginTransaction();
                            note.deleteFromRealm();
                            realm.commitTransaction();
                            Toast.makeText(context, "wish deleted", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });

                menu.show();
                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return notelist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView title,content;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.textview3);
            content=itemView.findViewById(R.id.textview4);
        }
    }
}
