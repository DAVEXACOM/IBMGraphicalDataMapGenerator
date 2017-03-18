package org.eclipse.jet.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_main implements JET2Template {

    public _jet_main() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
 com.ibm.etools.mft.pattern.support.Generation.onGenerate(context, "com.ibm.ObjectAssociation", "Id148670fa0d2bf751bb93051fce6", "Id148670fa0d591b58f8e9fa894b2", "pattern"); 
        out.write(NL);         
    }
}
