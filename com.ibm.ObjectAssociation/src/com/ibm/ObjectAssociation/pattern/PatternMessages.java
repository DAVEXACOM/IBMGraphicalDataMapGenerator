/**
 * Pattern program for use with IBM WebSphere Message Broker.
 *
 * COPYRIGHT NOTICE AND LICENSE
 * © Copyright International Business Machines Corporation 2009, 2011
 * Licensed Materials - Property of IBM
 *
 * On condition that the user is also then a licensed user of the specific 
 * version of the IBM product named above, this pattern program may be   
 * used, executed, copied and modified without obligation to make any  
 * royalty payment to IBM, as follows:
 *
 * (a) for the user's own instruction and study; and
 *
 * (b) in order to develop one or more applications designed to run with an IBM
 *     WebSphere Message Broker software product, either (i) for the licensed user's
 *     own internal use or (ii) for redistribution by the licensed user, as part of  
 *     such an application and in the licensed user's own product or products.
 *
 * No other rights under copyright are granted without prior written permission
 * of International Business Machines Corporation.
 *
 * In all other respects, the licensing terms and conditions associated with
 * the above-named IBM product continue to apply without modification.
 *
 * NO WARRANTY 
 * These materials and this sample program illustrate programming techniques. 
 * They have not been thoroughly tested under all conditions. 
 *
 * IBM therefore cannot and does not in any way guarantee, warrant represent 
 * or imply the reliability, serviceability, or function of this sample program. 
 * 
 * To the fullest extent permitted by applicable law, this program is provided by  
 * IBM "As Is", without warranty of any kind (express or implied), including without  
 * limitation any implied warranty of merchantability (satisfactory quality) or fitness 
 * for any particular purpose.
 */

package com.ibm.ObjectAssociation.pattern;

import java.util.Map;
import org.eclipse.osgi.util.NLS;
import com.ibm.ObjectAssociation.plugin.PatternBundle;
import com.ibm.ObjectAssociation.plugin.PatternPlugin;
import com.ibm.etools.patterns.model.base.IPatternBundle;

public class PatternMessages extends PatternBundle implements IPatternBundle {
	private static final String BUNDLE_NAME = "com.ibm.ObjectAssociation.pattern.messages"; //$NON-NLS-1$
	private static final Map<String, String> map;	
	private static final String[] enumerations = {
	 	"5061747465726E73216E6F6E65", //$NON-NLS-1$
	 	"5061747465726E7321616C6C", //$NON-NLS-1$
	 	"5061747465726E73216E6F6E65", //$NON-NLS-1$
	 	"5061747465726E7321757365726E616D65", //$NON-NLS-1$
	 	"5061747465726E7321757365726E616D65416E6450617373776F7264", //$NON-NLS-1$
	 	"5061747465726E7321582E353039", //$NON-NLS-1$
	 	"5061747465726E732153414D4C", //$NON-NLS-1$
	 	"5061747465726E73216E6F6E65", //$NON-NLS-1$
	 	"5061747465726E7321636F6E74656E74416E6456616C7565", //$NON-NLS-1$
	 	"5061747465726E7321636F6E74656E74", //$NON-NLS-1$
	 	"5061747465726E73216E6F6E65", //$NON-NLS-1$
	 	"5061747465726E7321616C6C", //$NON-NLS-1$
	 	"5061747465726E732164656661756C74", //$NON-NLS-1$
	 	"5061747465726E73216279557365724964", //$NON-NLS-1$
	 	"5061747465726E7321627951756575654F72646572", //$NON-NLS-1$
	 	"5061747465726E732175736572446566696E6564", //$NON-NLS-1$
	 	"5061747465726E73214446444C", //$NON-NLS-1$
	 	"5061747465726E7321584D4C4E5343", //$NON-NLS-1$
	 	"5061747465726E7321446174614F626A656374", //$NON-NLS-1$
	 	"5061747465726E73214A534F4E", //$NON-NLS-1$
	 	"5061747465726E7321424C4F42", //$NON-NLS-1$
	 	"5061747465726E73214D494D45", //$NON-NLS-1$
	 	"5061747465726E73214D524D", //$NON-NLS-1$
	 	"5061747465726E73214A4D534D6170", //$NON-NLS-1$
	 	"5061747465726E73214A4D5353747265616D", //$NON-NLS-1$
	 	"5061747465726E7321584D4C4E53", //$NON-NLS-1$
	 	"5061747465726E73216175746F6D61746963", //$NON-NLS-1$
	 	"5061747465726E7321796573", //$NON-NLS-1$
	 	"5061747465726E73216E6F", //$NON-NLS-1$
	 	"5061747465726E73216465666572726564", //$NON-NLS-1$
	 	"5061747465726E7321696D6D656469617465", //$NON-NLS-1$
	 	"5061747465726E7321636F6D706C657465", //$NON-NLS-1$
	 	"5061747465726E73216E6F6E65", //$NON-NLS-1$
	 	"5061747465726E7321616C6C", //$NON-NLS-1$
	 	"5061747465726E7321757365725472616365", //$NON-NLS-1$
	 	"5061747465726E73216C6F63616C4572726F72", //$NON-NLS-1$
	 	"5061747465726E7321657863657074696F6E", //$NON-NLS-1$
	 	"5061747465726E7321657863657074696F6E4C697374", //$NON-NLS-1$
	 	"5061747465726E7321666C6F77", //$NON-NLS-1$
	 	"5061747465726E73216E6F6465", //$NON-NLS-1$
	 	"5061747465726E73216D6170", //$NON-NLS-1$
	 	"5061747465726E73216573716C", //$NON-NLS-1$
	 	"5061747465726E73216A617661", //$NON-NLS-1$
	};
	
	public static String getStringStatic(String key) {
		return map.get(key);
	}
	
	public String getString(String key) {
		return map.get(key);
	}

	public static String com_ibm_ObjectAssociation_pattern_group_Id14868699f59270f17df9e47847b;		
	public static String com_ibm_ObjectAssociation_pattern_group_Id14868699f59270f17df9e47847b_description;		



	public static String com_ibm_ObjectAssociation_pattern_pov_root_pp1;		
	public static String com_ibm_ObjectAssociation_pattern_pov_root_pp1_watermark;		





	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c6cfb38f607b03c75c_5061747465726E73216E6F6E65;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c6cfb38f607b03c75c_5061747465726E7321616C6C;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c6b2c88e1bd52b890e_5061747465726E73216E6F6E65;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c6b2c88e1bd52b890e_5061747465726E7321757365726E616D65;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c6b2c88e1bd52b890e_5061747465726E7321757365726E616D65416E6450617373776F7264;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c6b2c88e1bd52b890e_5061747465726E7321582E353039;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c6b2c88e1bd52b890e_5061747465726E732153414D4C;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c67e8340855b52f172_5061747465726E73216E6F6E65;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c67e8340855b52f172_5061747465726E7321636F6E74656E74416E6456616C7565;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c67e8340855b52f172_5061747465726E7321636F6E74656E74;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c68b907313d6cc3182_5061747465726E73216E6F6E65;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c68b907313d6cc3182_5061747465726E7321616C6C;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c6fec75fcd98173cc4_5061747465726E732164656661756C74;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c6fec75fcd98173cc4_5061747465726E73216279557365724964;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c6fec75fcd98173cc4_5061747465726E7321627951756575654F72646572;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c6fec75fcd98173cc4_5061747465726E732175736572446566696E6564;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c616f0887ee5bc27f_5061747465726E73214446444C;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c616f0887ee5bc27f_5061747465726E7321584D4C4E5343;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c616f0887ee5bc27f_5061747465726E7321446174614F626A656374;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c616f0887ee5bc27f_5061747465726E73214A534F4E;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c616f0887ee5bc27f_5061747465726E7321424C4F42;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c616f0887ee5bc27f_5061747465726E73214D494D45;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c616f0887ee5bc27f_5061747465726E73214D524D;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c616f0887ee5bc27f_5061747465726E73214A4D534D6170;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c616f0887ee5bc27f_5061747465726E73214A4D5353747265616D;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c616f0887ee5bc27f_5061747465726E7321584D4C4E53;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c6be165647566e0ab1_5061747465726E73216175746F6D61746963;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c6be165647566e0ab1_5061747465726E7321796573;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c6be165647566e0ab1_5061747465726E73216E6F;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c6d6e2e276c317e53f_5061747465726E73216465666572726564;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c6d6e2e276c317e53f_5061747465726E7321696D6D656469617465;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c6d6e2e276c317e53f_5061747465726E7321636F6D706C657465;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c6242284df22dc7369_5061747465726E73216E6F6E65;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c6242284df22dc7369_5061747465726E7321616C6C;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c68c2f8abcb6b5d6c9_5061747465726E7321757365725472616365;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c68c2f8abcb6b5d6c9_5061747465726E73216C6F63616C4572726F72;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c68c2f8abcb6b5d6c9_5061747465726E7321657863657074696F6E;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c68c2f8abcb6b5d6c9_5061747465726E7321657863657074696F6E4C697374;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c669eabd2d540e591b_5061747465726E7321666C6F77;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id148671b19c669eabd2d540e591b_5061747465726E73216E6F6465;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id14867788d1d18dee1f67e3065c_5061747465726E73216D6170;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id14867788d1d18dee1f67e3065c_5061747465726E73216573716C;		
	public static String com_ibm_ObjectAssociation_pattern_pov_Id14867788d1d18dee1f67e3065c_5061747465726E73216A617661;		

	
	static {
		NLS.initializeMessages(BUNDLE_NAME, PatternMessages.class);
		PatternPlugin.addBundle(PatternMessages.class);
		map = PatternBundle.createMessageMap(PatternMessages.class, enumerations);
	}
}
