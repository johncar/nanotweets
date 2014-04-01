package com.nanotweets;

import java.util.regex.Pattern;

public class Settings {

	public static final String ONTOLOGY_FILE = "/home/jboss/ontologia/data/formato.owl";
	public static final String ONTOLOGY_NAME = "formato";
	public static final int QUERIES_CACHE_SIZE = 20;
	
	public static final boolean USE_DATABASE = false;
	public static final String JDBC_URL = "jdbc:oracle:thin:@192.168.56.101:1521:nexura";
	public static final String JDBC_USER = "nexura";
	public static final String JDBC_PASSWD = "n3xur4";
	
	public static final Integer RESPONSE_CODE_OK = 0;
	public static final Integer RESPONSE_CODE_PARAM_NOT_VALID = 101;
	public static final Integer RESPONSE_CODE_SERVICE_NOT_AVAILABLE = 102;
	public static final Integer RESPONSE_CODE_QUERY_EXEC_FAILURE = 103;
	public static final Integer RESPONSE_CODE_TECHNICAL_ERROR = 104;
	public static final Integer RESPONSE_CODE_IO_ERROR = 105;
	
	public static final String RESPONSE_MSG_TECHNICAL_ERROR = "Sorry, we are having a technical error at this moment";
	public static final String RESPONSE_MSG_OK = "Success!";
	
	public static final Integer DEFAULT_PAGE_SIZE = 10;
	
	public static final String SERVICE_ANNOTATE = "nanotate";
	public static final String SERVICE_SPARQL = "sparql";
	public static final String SERVICE_GET_THUMBNAILS = "thumbnails";
	public static final String SERVICE_CREATE_SESSION = "session";
	
	/**************************************************************************************
	 * HTTP GET/POST PARAMETERS
	 **************************************************************************************/
	
	public static final String PARAM_TEXT = "text";
	public static final String PARAM_FILTER_BY = "filterByType";
	public static final String PARAM_SUBJECT = "subject";
	public static final String PARAM_PROPERTY = "property";
	public static final String PARAM_OBJECT = "object";
	public static final String PARAM_PAGE_START = "iDisplayStart";
	public static final String PARAM_PAGE_SIZE = "iDisplayLength";
	public static final String PARAM_ORDER_BY = "sOrderBy";
	public static final String PARAM_QUERY = "query";
	public static final String PARAM_UUID = "uuid";
	public static final String SERVICE_LIST = "list";
    public static final String PARAM_COMMENT = "comment";

	
	/**************************************************************************************
	 * WHATIZIT SERVICE PIPELINES
	 **************************************************************************************/
	public static final String[] WHATIZIT_PIPELINE = new String[]{"whatizit_Abner","whatizitSwissprotGo",
		"whatizitSwissprot","whatizitProteinInteraction","whatizitValAccTagger","whatizitFMA","whatizitOscar3",
		"whatizitSwissprotFilter","whatizitDisease","whatizitProteinInteractionPMID","whatizitQbmarsdf",
		"whatizitProteinBiolexHuman","whatizitCheponer","whatizitEuropePmcGoterms","whatizitCALBCFilterTerm",
		"whatizitDiseaseUMLSDict","whatizitMetamap","whatizitEuropePmcGenesProteins","whatizitCellLine",
		"whatizitOrganisms","whatizitEFO","whatizitEuropePmcAll","whatizitOscar3a5","whatizitEBIMed","whatizitMeshUp",
		"whatizitPathwaywiki","whatizitEuropePmcSpecies","whatizitOrganismsFilter","whatizitPATO","whatizitGORanked",
		"whatizitDrugs","whatizitCALBCFilterId","whatizitSwissprotDisease","whatizitEuropePmcChemicals",
		"whatizitEBIMedDiseaseChemicals","whatizitEuropePmcDisease","whatizitISCN","whatizitChebiDict",
		"whatizitChemicals","whatizitOPB","whatizitSwissprotGo2","whatizitGODict","whatizitProteinDiseaseUMLS"};
	
	public static final Pattern pattern = Pattern.compile("<z:(.*?)</z:(.*?)>");



}
