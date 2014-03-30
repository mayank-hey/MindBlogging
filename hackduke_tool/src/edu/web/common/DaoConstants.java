/**
 * 
 */
package edu.web.common;

/**
 * @author Rohan Sabnis
 * 
 */
public class DaoConstants {

	public static final String CHECK_PATIENTINFO = "select count(*) from patient where patient_id = :patient_id";

	public static final String SELECT_ALLDOCUMENTINFO_LIST = "select document_id,patient_id,document_location,year_id,month_id,document_date,annotation_date from document_info";
	public static final String SELECT_PATIENTDOCUMENTINFO_LIST = "select document_id,patient_id,document_location,year_id,month_id,document_date,annotation_date from document_info where patient_id = :patient_id";
	public static final String INSERT_DOCUMENTINFO = "insert into document_info(patient_id,document_location,year_id,month_id,document_date,annotation_date) "
			+ "values (:patient_id,:document_location,:year_id,:month_id,:document_date,:annotation_date)";
	public static final String UPDATE_DOCUMENTINFO = "update document_info set patient_id = :patient_id,document_location = :document_location,year_id = :year_id,month_id = :month_id,"
			+ "document_date = :document_date,annotation_date = :annotation_date where document_id = :document_id";

	public static final String SELECT_ANNOTATIONINFO_LIST = "select annotation_id,document_id,annotation_text,annotation_quote,annotation_type_id,annotation_start,annotation_end,annotation_start_location,annotation_end_location,annotation_user,annotation_creation_date,annotation_update_date from annotation_info";
	public static final String SELECT_DOCUMENTANNOTATIONINFO_LIST = "select annotation_id,document_id,annotation_text,annotation_quote,annotation_type_id,annotation_start,annotation_end,annotation_start_location,annotation_end_location,annotation_user,annotation_creation_date,annotation_update_date from annotation_info where document_id = :document_id";
	public static final String SELECT_DOCUMENTANNOTATIONINFO = "select annotation_id,document_id,annotation_text,annotation_quote,annotation_type_id,annotation_start,annotation_end,annotation_start_location,annotation_end_location,annotation_user,annotation_creation_date,annotation_update_date from annotation_info where document_id = :document_id ORDER BY annotation_id DESC LIMIT 1";
	public static final String INSERT_ANNOTATIONINFO = "insert into annotation_info(document_id,annotation_text,annotation_quote,annotation_type_id,annotation_start,annotation_end,annotation_start_location,annotation_end_location,annotation_user,annotation_creation_date,annotation_update_date) "
			+ "values (:document_id,:annotation_text,:annotation_quote,:annotation_type_id,:annotation_start,:annotation_end,:annotation_start_location,:annotation_end_location,:annotation_user,:annotation_creation_date,:annotation_update_date)";
	public static final String BATCHINSERT_ANNOTATIONINFO = "insert into annotation_info(document_id,annotation_text,annotation_quote,annotation_type_id,annotation_start,annotation_end,annotation_start_location,annotation_end_location,annotation_user,annotation_creation_date,annotation_update_date) "
			+ "values (?,?,?,?,?,?,?,?,?,?,?)";
	public static final String UPDATE_ANNOTATIONINFO = "update annotation_info set document_id=:document_id,annotation_text=:annotation_text,annotation_quote=:annotation_quote,annotation_type_id=:annotation_type_id,annotation_start=:annotation_start,"
			+ "annotation_end=:annotation_end,annotation_start_location=:annotation_start_location,annotation_end_location=:annotation_end_location,annotation_user=:annotation_user,annotation_creation_date=:annotation_creation_date,"
			+ "annotation_update_date=:annotation_update_date where annotation_id = :annotation_id";
	public static final String BATCHUPDATE_ANNOTATIONINFO = "update annotation_info set document_id=?,annotation_text=?,annotation_quote=?,annotation_type_id=?,annotation_start=?,annotation_end=?,annotation_start_location=?,"
			+"annotation_end_location=?,annotation_user=?,annotation_creation_date=?,annotation_update_date=? where annotation_id = ?";
	public static final String DELETE_ANNOTATIONINFO = "delete from annotation_info where annotation_id = :annotation_id";

	public static final String SELECT_ANNOTATIONTYPEINFO_LIST = "select annotation_type_id,annotation_type,annotation_type_desc from annotation_type_info";
	public static final String SELECT_ANNOTATIONTYPEINFO = "select annotation_type_id,annotation_type,annotation_type_desc from annotation_type_info where annotation_type_id = :annotation_type_id";
	public static final String INSERT_ANNOTATIONTYPEINFO = "insert into annotation_type_info(annotation_type,annotation_type_desc)"
			+ "values (:annotation_type,:annotation_type_desc)";
	public static final String BATCHINSERT_ANNOTATIONTYPEINFO = "insert into annotation_type_info(annotation_type,annotation_type_desc)"
			+ "values (?,?)";
	public static final String UPDATE_ANNOTATIONTYPEINFO = "update annotation_type_info set annotation_type = :annotation_type,annotation_type_desc = :annotation_type_desc where annotation_type_id = :annotation_type_id";
	public static final String BATCHUPDATE_ANNOTATIONTYPEINFO = "update annotation_type_info set annotation_type = ?,annotation_type_desc = ? where annotation_type_id = ?";

}
