package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"from_id", "owner_id", "date", "marked_as_ads", "is_favorite", "post_type", "text", "is_pinned",
        "attachments", "post_source", "comments", "likes", "reposts", "views", "donut", "short_text_rate", "edited",
        "hash", "carousel_offset", "can_delete", "can_edit", "created_by", "can_pin", "zoom_text", "signer_id"})
public class Item {
    public int id;
}