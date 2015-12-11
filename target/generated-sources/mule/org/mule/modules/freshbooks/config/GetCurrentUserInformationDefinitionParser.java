
package org.mule.modules.freshbooks.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.modules.freshbooks.api.holders.OAuthCredentialsExpressionHolder;
import org.mule.modules.freshbooks.processors.GetCurrentUserInformationMessageProcessor;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.BeanDefinitionParsingException;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.2", date = "2015-12-11T05:53:18-03:00", comments = "Build 3.7.x.2633.51164b9")
public class GetCurrentUserInformationDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(GetCurrentUserInformationDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(GetCurrentUserInformationMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [get-current-user-information] within the connector [freshbooks] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [get-current-user-information] within the connector [freshbooks] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("getCurrentUserInformation");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [get-current-user-information] within the connector [freshbooks] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        parseProperty(builder, element, "sourceToken", "sourceToken");
        parseProperty(builder, element, "accessTokenId", "accessTokenId");
        if (!parseObjectRef(element, builder, "credentials", "credentials")) {
            BeanDefinitionBuilder credentialsBuilder = BeanDefinitionBuilder.rootBeanDefinition(OAuthCredentialsExpressionHolder.class.getName());
            Element credentialsChildElement = DomUtils.getChildElementByTagName(element, "credentials");
            if (credentialsChildElement!= null) {
                parseProperty(credentialsBuilder, credentialsChildElement, "accessToken", "accessToken");
                parseProperty(credentialsBuilder, credentialsChildElement, "accessTokenSecret", "accessTokenSecret");
                parseProperty(credentialsBuilder, credentialsChildElement, "userId", "userId");
                parseProperty(credentialsBuilder, credentialsChildElement, "requestTokenUrl", "requestTokenUrl");
                parseProperty(credentialsBuilder, credentialsChildElement, "authUrl", "authUrl");
                parseProperty(credentialsBuilder, credentialsChildElement, "accessTokenUrl", "accessTokenUrl");
                parseProperty(credentialsBuilder, credentialsChildElement, "apiUrl", "apiUrl");
                builder.addPropertyValue("credentials", credentialsBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
