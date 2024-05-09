package sg.edu.np.mad.madpractical4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    ArrayList<User> list_objects;
    private ListActivity activity;


    public UserAdapter(ArrayList<User> list_objects, ListActivity activity) {
        this.list_objects = list_objects;
        this.activity = activity;
    }

    //viewholder pos
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_activity_list, parent, false);

        return new UserViewHolder(view);
    }


    public void onBindViewHolder(UserViewHolder holder, int position){
        //name pos
        User list_items = list_objects.get(position);

        holder.name.setText(list_items.getName());

        holder.description.setText(list_items.getDescription());


        holder.smallImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Profile");
                builder.setMessage(list_items.getName());
                builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //intent for view button

                        Intent intent = new Intent(v.getContext(), MainActivity.class);
                        intent.putExtra("name", list_items.getName());
                        intent.putExtra("description", list_items.getDescription());
                        v.getContext().startActivity(intent);
                    }
                });
                builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //dismiss
                        dialog.dismiss();
                    }
                });
                // show dialog
                builder.create().show();
            }

        });
        String userId =String.valueOf(list_items.getName());
        if (userId.contains("7")) {
            holder.bigImage.setVisibility(View.VISIBLE);
        }
        else {
            holder.bigImage.setVisibility(View.GONE);
        }
    }
    public int getItemCount() {
        return list_objects.size();
    }
}