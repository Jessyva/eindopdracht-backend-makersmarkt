package com.example.Makersmarkt.service;

import com.example.Makersmarkt.controller.ProductOndernemerController;
import com.example.Makersmarkt.dto.MarktOndernemerDTO;
import com.example.Makersmarkt.dto.OndernemerDTO;
import com.example.Makersmarkt.dto.ProductondernemerDTO;
import org.springframework.data.projection.EntityProjection;

import java.util.List;

public class OndernemerService {
    public static void updateUserPassword(String username, OndernemerDTO dto) {
    }

    public static void saveProfile(ProductOndernemerController profile) {
        
    }

    public String createOndernemer(MarktOndernemerDTO dto) {
        return "";
    }

    public OndernemerDTO getOndernemer(String username) {
        return null;
    }

    public void addAuthority(String newUsername, String roleMarktOndernemer) {
    }

    public String createUser(ProductondernemerDTO dto) {
        return null;
    }

    public static String getCurrentLoggedInUsername() {
        return null;
    }

    public void updateOndernemerPassword(String username, OndernemerDTO dto) {
    }

    public void deleteOndernemer(String username) {
    }

    public Object getAuthorities(String username) {
        return null;
    }

    public void removeAuthority(String username, String authority) {
    }

    public void updateOndernemerPassword(String username, EntityProjection.ProjectionType projectionType) {
    }

    public List<OndernemerDTO> getOndernemers() {
        return null;
    }
}
