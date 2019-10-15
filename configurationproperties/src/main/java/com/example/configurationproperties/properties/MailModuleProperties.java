package com.example.configurationproperties.properties;

import com.example.configurationproperties.entity.Weight;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.DeprecatedConfigurationProperty;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * @author fraser
 * @date 2019-07-23 19:40
 */
//@Data
//@Validated
@Component
@ConfigurationProperties(prefix = "myapp.mail")
public class MailModuleProperties {

	@NotNull
	private Boolean enabled;

	@NotEmpty
	private String defaultSubject;

	private List<String> smtpServers;

	@DurationUnit(ChronoUnit.DAYS)
	private Duration pauseBetweenMails = Duration.ofSeconds(30);


	@DataSizeUnit(DataUnit.MEGABYTES)
	private DataSize maxAttachmentSize = DataSize.ofMegabytes(2);

	private Weight maxAttachmentWeight;

	@DeprecatedConfigurationProperty(reason = "change name", replacement = "none")
	public String getDefaultSubject() {
		return defaultSubject;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public void setDefaultSubject(String defaultSubject) {
		this.defaultSubject = defaultSubject;
	}

	public List<String> getSmtpServers() {
		return smtpServers;
	}

	public void setSmtpServers(List<String> smtpServers) {
		this.smtpServers = smtpServers;
	}

	public Duration getPauseBetweenMails() {
		return pauseBetweenMails;
	}

	public void setPauseBetweenMails(Duration pauseBetweenMails) {
		this.pauseBetweenMails = pauseBetweenMails;
	}

	public DataSize getMaxAttachmentSize() {
		return maxAttachmentSize;
	}

	public void setMaxAttachmentSize(DataSize maxAttachmentSize) {
		this.maxAttachmentSize = maxAttachmentSize;
	}

	public Weight getMaxAttachmentWeight() {
		return maxAttachmentWeight;
	}

	public void setMaxAttachmentWeight(Weight maxAttachmentWeight) {
		this.maxAttachmentWeight = maxAttachmentWeight;
	}
}
