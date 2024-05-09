package sg.edu.np.mad.madpractical4;

import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    ImageView smallImage;
    ImageView bigImage;
    TextView name;
    TextView description;

    public UserViewHolder(View itemView){
        super(itemView);
        bigImage = itemView.findViewById(R.id.ivBigImage);
        smallImage = itemView.findViewById(R.id.ivSmallImage);
        name  = itemView.findViewById(R.id.tvName);
        description = itemView.findViewById(R.id.tvDescription);
    }
}
