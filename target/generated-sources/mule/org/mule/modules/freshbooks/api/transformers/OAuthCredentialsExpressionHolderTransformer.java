
package org.mule.modules.freshbooks.api.transformers;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.endpoint.ImmutableEndpoint;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.transformer.DataType;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.MessageTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transformer.TransformerMessagingException;
import org.mule.config.i18n.CoreMessages;
import org.mule.devkit.processor.ExpressionEvaluatorSupport;
import org.mule.modules.freshbooks.api.OAuthCredentials;
import org.mule.modules.freshbooks.api.holders.OAuthCredentialsExpressionHolder;
import org.mule.transformer.types.DataTypeFactory;
import org.mule.transport.NullPayload;
import org.mule.util.TemplateParser;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.2", date = "2015-12-11T05:53:18-03:00", comments = "Build 3.7.x.2633.51164b9")
public class OAuthCredentialsExpressionHolderTransformer
    extends ExpressionEvaluatorSupport
    implements DiscoverableTransformer, MessageTransformer
{

    private int weighting = DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING;
    private ImmutableEndpoint endpoint;
    private MuleContext muleContext;
    private String name;

    public int getPriorityWeighting() {
        return weighting;
    }

    public void setPriorityWeighting(int weighting) {
        this.weighting = weighting;
    }

    public boolean isSourceTypeSupported(Class<?> aClass) {
        return (aClass == OAuthCredentialsExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == OAuthCredentialsExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {OAuthCredentialsExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(OAuthCredentialsExpressionHolder.class)});
    }

    public boolean isAcceptNull() {
        return false;
    }

    public boolean isIgnoreBadInput() {
        return false;
    }

    public Object transform(Object src)
        throws TransformerException
    {
        throw new UnsupportedOperationException();
    }

    public Object transform(Object src, String encoding)
        throws TransformerException
    {
        throw new UnsupportedOperationException();
    }

    public void setReturnClass(Class<?> theClass) {
        throw new UnsupportedOperationException();
    }

    public Class<?> getReturnClass() {
        return OAuthCredentials.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(OAuthCredentials.class);
    }

    public void setEndpoint(ImmutableEndpoint ep) {
        endpoint = ep;
    }

    public ImmutableEndpoint getEndpoint() {
        return endpoint;
    }

    public void dispose() {
    }

    public void initialise()
        throws InitialisationException
    {
    }

    public void setMuleContext(MuleContext context) {
        muleContext = context;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public Object transform(Object src, MuleEvent event)
        throws TransformerMessagingException
    {
        return transform(src, null, event);
    }

    public Object transform(Object src, String encoding, MuleEvent event)
        throws TransformerMessagingException
    {
        if (src == null) {
            return null;
        }
        OAuthCredentialsExpressionHolder holder = ((OAuthCredentialsExpressionHolder) src);
        OAuthCredentials result = new OAuthCredentials();
        try {
            final String _transformedAccessToken = ((String) evaluateAndTransform(this.muleContext, event, OAuthCredentialsExpressionHolder.class.getDeclaredField("_accessTokenType").getGenericType(), null, holder.getAccessToken()));
            result.setAccessToken(_transformedAccessToken);
            final String _transformedAccessTokenSecret = ((String) evaluateAndTransform(this.muleContext, event, OAuthCredentialsExpressionHolder.class.getDeclaredField("_accessTokenSecretType").getGenericType(), null, holder.getAccessTokenSecret()));
            result.setAccessTokenSecret(_transformedAccessTokenSecret);
            final String _transformedUserId = ((String) evaluateAndTransform(this.muleContext, event, OAuthCredentialsExpressionHolder.class.getDeclaredField("_userIdType").getGenericType(), null, holder.getUserId()));
            result.setUserId(_transformedUserId);
            final String _transformedRequestTokenUrl = ((String) evaluateAndTransform(this.muleContext, event, OAuthCredentialsExpressionHolder.class.getDeclaredField("_requestTokenUrlType").getGenericType(), null, holder.getRequestTokenUrl()));
            result.setRequestTokenUrl(_transformedRequestTokenUrl);
            final String _transformedAuthUrl = ((String) evaluateAndTransform(this.muleContext, event, OAuthCredentialsExpressionHolder.class.getDeclaredField("_authUrlType").getGenericType(), null, holder.getAuthUrl()));
            result.setAuthUrl(_transformedAuthUrl);
            final String _transformedAccessTokenUrl = ((String) evaluateAndTransform(this.muleContext, event, OAuthCredentialsExpressionHolder.class.getDeclaredField("_accessTokenUrlType").getGenericType(), null, holder.getAccessTokenUrl()));
            result.setAccessTokenUrl(_transformedAccessTokenUrl);
            final String _transformedApiUrl = ((String) evaluateAndTransform(this.muleContext, event, OAuthCredentialsExpressionHolder.class.getDeclaredField("_apiUrlType").getGenericType(), null, holder.getApiUrl()));
            result.setApiUrl(_transformedApiUrl);
        } catch (NoSuchFieldException e) {
            throw new TransformerMessagingException(CoreMessages.createStaticMessage("internal error"), event, this, e);
        } catch (TransformerException e) {
            throw new TransformerMessagingException(e.getI18nMessage(), event, this, e);
        }
        return result;
    }

    public MuleEvent process(MuleEvent event) {
        return null;
    }

    public String getMimeType() {
        return null;
    }

    public String getEncoding() {
        return null;
    }

    public MuleContext getMuleContext() {
        return muleContext;
    }

    private Object evaluateTransformForPayload(MuleContext muleContext, MuleEvent muleEvent, Type objectType, String mimeType, Object object)
        throws TransformerException, TransformerMessagingException
    {
        Object transformedObject;
        try {
            transformedObject = evaluateAndTransform(muleContext, muleEvent, objectType, mimeType, object);
            if (transformedObject instanceof NullPayload) {
                transformedObject = null;
            }
        } catch (TransformerException e) {
            transformedObject = evaluate(TemplateParser.createMuleStyleParser().getStyle(), muleContext.getExpressionManager(), muleEvent.getMessage(), object);
            if (transformedObject instanceof NullPayload) {
                transformedObject = null;
            } else {
                throw e;
            }
        } catch (TransformerMessagingException e) {
            transformedObject = evaluate(TemplateParser.createMuleStyleParser().getStyle(), muleContext.getExpressionManager(), muleEvent.getMessage(), object);
            if (transformedObject instanceof NullPayload) {
                transformedObject = null;
            } else {
                throw e;
            }
        }
        return transformedObject;
    }

}
