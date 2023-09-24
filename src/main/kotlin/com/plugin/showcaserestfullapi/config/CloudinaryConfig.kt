package com.plugin.showcaserestfullapi.config

import com.cloudinary.Cloudinary
import com.cloudinary.utils.ObjectUtils
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CloudinaryConfig {
    @Bean
    fun cloudinaryAccount() : Cloudinary{
        return Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dogsfnh4s",
            "api_key", "244574214117538",
            "api_secret", "SRfACGjwdmii8PAFDCanUe5p81Q"
        ))
    }
}