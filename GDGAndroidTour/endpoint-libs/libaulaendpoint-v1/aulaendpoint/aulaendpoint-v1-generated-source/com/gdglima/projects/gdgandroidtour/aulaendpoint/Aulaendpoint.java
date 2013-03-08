/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This file was generated.
 *  with google-apis-code-generator 1.2.0 (build: 2013-03-04 17:44:07 UTC)
 *  on 2013-03-08 at 23:43:44 UTC 
 */

package com.gdglima.projects.gdgandroidtour.aulaendpoint;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.JsonString;
import com.google.common.base.Preconditions;

/**
 * Service definition for Aulaendpoint (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link AulaendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * <p>
 * Upgrade warning: this class now extends {@link AbstractGoogleJsonClient}, whereas in prior
 * version 1.8 it extended {@link com.google.api.client.googleapis.services.GoogleClient}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Aulaendpoint extends AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    Preconditions.checkState(GoogleUtils.VERSION.equals("1.13.2-beta"),
        "You are currently running with version %s of google-api-client. " +
        "You need version 1.13.2-beta of google-api-client to run version " +
        "1.13.2-beta of the  library.", GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://myapp.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "aulaendpoint/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   * @deprecated (scheduled to be removed in 1.13)
   */
  @Deprecated
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport
   * @param jsonFactory JSON factory
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Aulaendpoint(HttpTransport transport, JsonFactory jsonFactory,
      HttpRequestInitializer httpRequestInitializer) {
    super(transport,
        jsonFactory,
        DEFAULT_ROOT_URL,
        DEFAULT_SERVICE_PATH,
        httpRequestInitializer,
        false);
  }

  /**
   * @param transport HTTP transport
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @param rootUrl root URL of the service
   * @param servicePath service path
   * @param jsonObjectParser JSON object parser
   * @param googleClientRequestInitializer Google request initializer or {@code null} for none
   * @param applicationName application name to be sent in the User-Agent header of requests or
   *        {@code null} for none
   * @param suppressPatternChecks whether discovery pattern checks should be suppressed on required
   *        parameters
   */
  Aulaendpoint(HttpTransport transport,
      HttpRequestInitializer httpRequestInitializer,
      String rootUrl,
      String servicePath,
      JsonObjectParser jsonObjectParser,
      GoogleClientRequestInitializer googleClientRequestInitializer,
      String applicationName,
      boolean suppressPatternChecks) {
    super(transport,
        httpRequestInitializer,
        rootUrl,
        servicePath,
        jsonObjectParser,
        googleClientRequestInitializer,
        applicationName,
        suppressPatternChecks);
  }

  @Override
  protected void initialize(AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getAula".
   *
   * This request holds the parameters needed by the the aulaendpoint server.  After setting any
   * optional parameters, call the {@link GetAula#execute()} method to invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public GetAula getAula(Long id) throws java.io.IOException {
    GetAula result = new GetAula(id);
    initialize(result);
    return result;
  }

  public class GetAula extends AulaendpointRequest<com.gdglima.projects.gdgandroidtour.aulaendpoint.model.Aula> {

    private static final String REST_PATH = "aula/{id}";

    /**
     * Create a request for the method "getAula".
     *
     * This request holds the parameters needed by the the aulaendpoint server.  After setting any
     * optional parameters, call the {@link GetAula#execute()} method to invoke the remote operation.
     * <p> {@link GetAula#initialize(AbstractGoogleClientRequest)} must be called to initialize this
     * instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetAula(Long id) {
      super(Aulaendpoint.this, "GET", REST_PATH, null, com.gdglima.projects.gdgandroidtour.aulaendpoint.model.Aula.class);
      this.id = Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetAula setAlt(String alt) {
      return (GetAula) super.setAlt(alt);
    }

    @Override
    public GetAula setFields(String fields) {
      return (GetAula) super.setFields(fields);
    }

    @Override
    public GetAula setKey(String key) {
      return (GetAula) super.setKey(key);
    }

    @Override
    public GetAula setOauthToken(String oauthToken) {
      return (GetAula) super.setOauthToken(oauthToken);
    }

    @Override
    public GetAula setPrettyPrint(Boolean prettyPrint) {
      return (GetAula) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetAula setQuotaUser(String quotaUser) {
      return (GetAula) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetAula setUserIp(String userIp) {
      return (GetAula) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private Long id;

    /**

     */
    public Long getId() {
      return id;
    }

    public GetAula setId(Long id) {
      this.id = id;
      return this;
    }

  }

  /**
   * Create a request for the method "insertAula".
   *
   * This request holds the parameters needed by the the aulaendpoint server.  After setting any
   * optional parameters, call the {@link InsertAula#execute()} method to invoke the remote operation.
   *
   * @param content the {@link com.gdglima.projects.gdgandroidtour.aulaendpoint.model.Aula}
   * @return the request
   */
  public InsertAula insertAula(com.gdglima.projects.gdgandroidtour.aulaendpoint.model.Aula content) throws java.io.IOException {
    InsertAula result = new InsertAula(content);
    initialize(result);
    return result;
  }

  public class InsertAula extends AulaendpointRequest<com.gdglima.projects.gdgandroidtour.aulaendpoint.model.Aula> {

    private static final String REST_PATH = "aula";

    /**
     * Create a request for the method "insertAula".
     *
     * This request holds the parameters needed by the the aulaendpoint server.  After setting any
     * optional parameters, call the {@link InsertAula#execute()} method to invoke the remote
     * operation. <p> {@link InsertAula#initialize(AbstractGoogleClientRequest)} must be called to
     * initialize this instance immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.gdglima.projects.gdgandroidtour.aulaendpoint.model.Aula}
     * @since 1.13
     */
    protected InsertAula(com.gdglima.projects.gdgandroidtour.aulaendpoint.model.Aula content) {
      super(Aulaendpoint.this, "POST", REST_PATH, content, com.gdglima.projects.gdgandroidtour.aulaendpoint.model.Aula.class);
    }

    @Override
    public InsertAula setAlt(String alt) {
      return (InsertAula) super.setAlt(alt);
    }

    @Override
    public InsertAula setFields(String fields) {
      return (InsertAula) super.setFields(fields);
    }

    @Override
    public InsertAula setKey(String key) {
      return (InsertAula) super.setKey(key);
    }

    @Override
    public InsertAula setOauthToken(String oauthToken) {
      return (InsertAula) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertAula setPrettyPrint(Boolean prettyPrint) {
      return (InsertAula) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertAula setQuotaUser(String quotaUser) {
      return (InsertAula) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertAula setUserIp(String userIp) {
      return (InsertAula) super.setUserIp(userIp);
    }

  }

  /**
   * Create a request for the method "listAula".
   *
   * This request holds the parameters needed by the the aulaendpoint server.  After setting any
   * optional parameters, call the {@link ListAula#execute()} method to invoke the remote operation.
   *
   * @return the request
   */
  public ListAula listAula() throws java.io.IOException {
    ListAula result = new ListAula();
    initialize(result);
    return result;
  }

  public class ListAula extends AulaendpointRequest<com.gdglima.projects.gdgandroidtour.aulaendpoint.model.CollectionResponseAula> {

    private static final String REST_PATH = "aula";

    /**
     * Create a request for the method "listAula".
     *
     * This request holds the parameters needed by the the aulaendpoint server.  After setting any
     * optional parameters, call the {@link ListAula#execute()} method to invoke the remote operation.
     * <p> {@link ListAula#initialize(AbstractGoogleClientRequest)} must be called to initialize this
     * instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected ListAula() {
      super(Aulaendpoint.this, "GET", REST_PATH, null, com.gdglima.projects.gdgandroidtour.aulaendpoint.model.CollectionResponseAula.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public ListAula setAlt(String alt) {
      return (ListAula) super.setAlt(alt);
    }

    @Override
    public ListAula setFields(String fields) {
      return (ListAula) super.setFields(fields);
    }

    @Override
    public ListAula setKey(String key) {
      return (ListAula) super.setKey(key);
    }

    @Override
    public ListAula setOauthToken(String oauthToken) {
      return (ListAula) super.setOauthToken(oauthToken);
    }

    @Override
    public ListAula setPrettyPrint(Boolean prettyPrint) {
      return (ListAula) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListAula setQuotaUser(String quotaUser) {
      return (ListAula) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListAula setUserIp(String userIp) {
      return (ListAula) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private String cursor;

    /**

     */
    public String getCursor() {
      return cursor;
    }

    public ListAula setCursor(String cursor) {
      this.cursor = cursor;
      return this;
    }

    @com.google.api.client.util.Key
    private Integer limit;

    /**

     */
    public Integer getLimit() {
      return limit;
    }

    public ListAula setLimit(Integer limit) {
      this.limit = limit;
      return this;
    }

  }

  /**
   * Create a request for the method "removeAula".
   *
   * This request holds the parameters needed by the the aulaendpoint server.  After setting any
   * optional parameters, call the {@link RemoveAula#execute()} method to invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public RemoveAula removeAula(Long id) throws java.io.IOException {
    RemoveAula result = new RemoveAula(id);
    initialize(result);
    return result;
  }

  public class RemoveAula extends AulaendpointRequest<com.gdglima.projects.gdgandroidtour.aulaendpoint.model.Aula> {

    private static final String REST_PATH = "aula/{id}";

    /**
     * Create a request for the method "removeAula".
     *
     * This request holds the parameters needed by the the aulaendpoint server.  After setting any
     * optional parameters, call the {@link RemoveAula#execute()} method to invoke the remote
     * operation. <p> {@link RemoveAula#initialize(AbstractGoogleClientRequest)} must be called to
     * initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveAula(Long id) {
      super(Aulaendpoint.this, "DELETE", REST_PATH, null, com.gdglima.projects.gdgandroidtour.aulaendpoint.model.Aula.class);
      this.id = Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveAula setAlt(String alt) {
      return (RemoveAula) super.setAlt(alt);
    }

    @Override
    public RemoveAula setFields(String fields) {
      return (RemoveAula) super.setFields(fields);
    }

    @Override
    public RemoveAula setKey(String key) {
      return (RemoveAula) super.setKey(key);
    }

    @Override
    public RemoveAula setOauthToken(String oauthToken) {
      return (RemoveAula) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveAula setPrettyPrint(Boolean prettyPrint) {
      return (RemoveAula) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveAula setQuotaUser(String quotaUser) {
      return (RemoveAula) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveAula setUserIp(String userIp) {
      return (RemoveAula) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private Long id;

    /**

     */
    public Long getId() {
      return id;
    }

    public RemoveAula setId(Long id) {
      this.id = id;
      return this;
    }

  }

  /**
   * Create a request for the method "updateAula".
   *
   * This request holds the parameters needed by the the aulaendpoint server.  After setting any
   * optional parameters, call the {@link UpdateAula#execute()} method to invoke the remote operation.
   *
   * @param content the {@link com.gdglima.projects.gdgandroidtour.aulaendpoint.model.Aula}
   * @return the request
   */
  public UpdateAula updateAula(com.gdglima.projects.gdgandroidtour.aulaendpoint.model.Aula content) throws java.io.IOException {
    UpdateAula result = new UpdateAula(content);
    initialize(result);
    return result;
  }

  public class UpdateAula extends AulaendpointRequest<com.gdglima.projects.gdgandroidtour.aulaendpoint.model.Aula> {

    private static final String REST_PATH = "aula";

    /**
     * Create a request for the method "updateAula".
     *
     * This request holds the parameters needed by the the aulaendpoint server.  After setting any
     * optional parameters, call the {@link UpdateAula#execute()} method to invoke the remote
     * operation. <p> {@link UpdateAula#initialize(AbstractGoogleClientRequest)} must be called to
     * initialize this instance immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.gdglima.projects.gdgandroidtour.aulaendpoint.model.Aula}
     * @since 1.13
     */
    protected UpdateAula(com.gdglima.projects.gdgandroidtour.aulaendpoint.model.Aula content) {
      super(Aulaendpoint.this, "PUT", REST_PATH, content, com.gdglima.projects.gdgandroidtour.aulaendpoint.model.Aula.class);
    }

    @Override
    public UpdateAula setAlt(String alt) {
      return (UpdateAula) super.setAlt(alt);
    }

    @Override
    public UpdateAula setFields(String fields) {
      return (UpdateAula) super.setFields(fields);
    }

    @Override
    public UpdateAula setKey(String key) {
      return (UpdateAula) super.setKey(key);
    }

    @Override
    public UpdateAula setOauthToken(String oauthToken) {
      return (UpdateAula) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateAula setPrettyPrint(Boolean prettyPrint) {
      return (UpdateAula) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateAula setQuotaUser(String quotaUser) {
      return (UpdateAula) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateAula setUserIp(String userIp) {
      return (UpdateAula) super.setUserIp(userIp);
    }

  }

  /**
   * Builder for {@link Aulaendpoint}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport
     * @param jsonFactory JSON factory
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(HttpTransport transport, JsonFactory jsonFactory,
        HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Aulaendpoint}. */
    @Override
    public Aulaendpoint build() {
      return new Aulaendpoint(getTransport(),
          getHttpRequestInitializer(),
          getRootUrl(),
          getServicePath(),
          getObjectParser(),
          getGoogleClientRequestInitializer(),
          getApplicationName(),
          getSuppressPatternChecks());
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    /**
     * Set the {@link AulaendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setAulaendpointRequestInitializer(
        AulaendpointRequestInitializer aulaendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(aulaendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
