
package org.mule.modules.freshbooks.processors;

import java.lang.reflect.Type;
import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.config.ConfigurationException;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.registry.RegistrationException;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transformer.TransformerMessagingException;
import org.mule.common.DefaultResult;
import org.mule.common.FailureType;
import org.mule.common.Result;
import org.mule.common.metadata.ConnectorMetaDataEnabled;
import org.mule.common.metadata.DefaultMetaData;
import org.mule.common.metadata.DefaultMetaDataKey;
import org.mule.common.metadata.DefaultPojoMetaDataModel;
import org.mule.common.metadata.DefaultSimpleMetaDataModel;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataKey;
import org.mule.common.metadata.MetaDataModel;
import org.mule.common.metadata.OperationMetaDataEnabled;
import org.mule.common.metadata.datatype.DataType;
import org.mule.common.metadata.datatype.DataTypeFactory;
import org.mule.devkit.internal.metadata.fixes.STUDIO7157;
import org.mule.devkit.processor.DevkitBasedMessageProcessor;
import org.mule.modules.freshbooks.FreshBooksConnector;
import org.mule.modules.freshbooks.model.Task;
import org.mule.security.oauth.callback.ProcessCallback;
import org.mule.transport.NullPayload;
import org.mule.util.TemplateParser;


/**
 * CreateTaskMessageProcessor invokes the {@link org.mule.modules.freshbooks.FreshBooksConnector#createTask(java.lang.String, org.mule.modules.freshbooks.model.Task, java.lang.String)} method in {@link FreshBooksConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.2", date = "2015-12-11T05:53:18-03:00", comments = "Build 3.7.x.2633.51164b9")
public class CreateTaskMessageProcessor
    extends DevkitBasedMessageProcessor
    implements MessageProcessor, OperationMetaDataEnabled
{

    protected Object sourceToken;
    protected String _sourceTokenType;
    protected Object task;
    protected Task _taskType;

    public CreateTaskMessageProcessor(String operationName) {
        super(operationName);
    }

    /**
     * Obtains the expression manager from the Mule context and initialises the connector. If a target object  has not been set already it will search the Mule registry for a default one.
     * 
     * @throws InitialisationException
     */
    public void initialise()
        throws InitialisationException
    {
    }

    @Override
    public void start()
        throws MuleException
    {
        super.start();
    }

    @Override
    public void stop()
        throws MuleException
    {
        super.stop();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    /**
     * Sets task
     * 
     * @param value Value to set
     */
    public void setTask(Object value) {
        this.task = value;
    }

    /**
     * Sets sourceToken
     * 
     * @param value Value to set
     */
    public void setSourceToken(Object value) {
        this.sourceToken = value;
    }

    /**
     * Invokes the MessageProcessor.
     * 
     * @param event MuleEvent to be processed
     * @throws Exception
     */
    public MuleEvent doProcess(final MuleEvent event)
        throws Exception
    {
        Object moduleObject = null;
        try {
            moduleObject = findOrCreate(null, false, event);
            final String _transformedSourceToken = ((String) evaluateAndTransform(getMuleContext(), event, CreateTaskMessageProcessor.class.getDeclaredField("_sourceTokenType").getGenericType(), null, sourceToken));
            final Task _transformedTask = ((Task) evaluateTransformForPayload(getMuleContext(), event, CreateTaskMessageProcessor.class.getDeclaredField("_taskType").getGenericType(), null, task));
            final String _transformedAccessTokenId = ((String) evaluateAndTransform(getMuleContext(), event, DevkitBasedMessageProcessor.class.getDeclaredField("accessTokenId").getGenericType(), null, super.getAccessTokenId()));
            Object resultPayload;
            final ProcessTemplate<Object, Object> processTemplate = ((ProcessAdapter<Object> ) moduleObject).getProcessTemplate();
            resultPayload = processTemplate.execute(new ProcessCallback<Object,Object>() {


                public List<Class<? extends Exception>> getManagedExceptions() {
                    return null;
                }

                public boolean isProtected() {
                    return false;
                }

                public Object process(Object object)
                    throws Exception
                {
                    return ((FreshBooksConnector) object).createTask(_transformedSourceToken, _transformedTask, _transformedAccessTokenId);
                }

            }
            , this, event);
            event.getMessage().setPayload(resultPayload);
            return event;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Result<MetaData> getInputMetaData() {
        MetaDataModel metaDataPayload = getPojoOrSimpleModel(Task.class);
        DefaultMetaDataKey keyForStudio = new DefaultMetaDataKey("INPUT_METADATA", null);
        metaDataPayload.addProperty(STUDIO7157 .getStructureIdentifierMetaDataModelProperty(keyForStudio, false, false));
        return new DefaultResult<MetaData>(new DefaultMetaData(metaDataPayload));
    }

    @Override
    public Result<MetaData> getOutputMetaData(MetaData inputMetadata) {
        MetaDataModel metaDataPayload = getPojoOrSimpleModel(Task.class);
        DefaultMetaDataKey keyForStudio = new DefaultMetaDataKey("OUTPUT_METADATA", null);
        metaDataPayload.addProperty(STUDIO7157 .getStructureIdentifierMetaDataModelProperty(keyForStudio, false, false));
        return new DefaultResult<MetaData>(new DefaultMetaData(metaDataPayload));
    }

    private MetaDataModel getPojoOrSimpleModel(Class clazz) {
        DataType dataType = DataTypeFactory.getInstance().getDataType(clazz);
        if (DataType.POJO.equals(dataType)) {
            return new DefaultPojoMetaDataModel(clazz);
        } else {
            return new DefaultSimpleMetaDataModel(dataType);
        }
    }

    public Result<MetaData> getGenericMetaData(MetaDataKey metaDataKey) {
        ConnectorMetaDataEnabled connector;
        try {
            connector = ((ConnectorMetaDataEnabled) findOrCreate(null, false, null));
            try {
                Result<MetaData> metadata = connector.getMetaData(metaDataKey);
                if ((Result.Status.FAILURE).equals(metadata.getStatus())) {
                    return metadata;
                }
                if (metadata.get() == null) {
                    return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error processing metadata at FreshBooksConnector at createTask retrieving was successful but result is null");
                }
                return metadata;
            } catch (Exception e) {
                return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
            }
        } catch (ClassCastException cast) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error getting metadata, there was no connection manager available. Maybe you're trying to use metadata from an Oauth connector");
        } catch (ConfigurationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (RegistrationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (IllegalAccessException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (InstantiationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (Exception e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        }
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
