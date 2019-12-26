

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.ImageIcon;
import java.net.URL;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;

public class XMSSmodules extends JPanel 
                          implements TreeSelectionListener {
    private JEditorPane htmlPane;
    private JTree tree;
    private URL helpURL;
    private static boolean DEBUG = false;

    public XMSSmodules() {
        super(new BorderLayout());

        //Create the nodes.        
        DefaultMutableTreeNode top =
            new DefaultMutableTreeNode("myXMSS");
        createNodes(top);

        //Create a tree that allows one selection at a time.
        tree = new JTree(top);
        tree.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);

        //Set the icon for leaf nodes.
        ImageIcon leafIcon = createImageIcon("images/middle.gif");
        if (leafIcon != null) {
            DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
            renderer.setLeafIcon(leafIcon);
            tree.setCellRenderer(renderer);
        } else {
            System.err.println("Leaf icon missing; using default.");
        }

        //Listen for when the selection changes.
        tree.addTreeSelectionListener(this);

        //Create the scroll pane and add the tree to it. 
        JScrollPane treeView = new JScrollPane(tree);

        //Create the HTML viewing pane.
        htmlPane = new JEditorPane();
        htmlPane.setEditable(false);
        initHelp();
        JScrollPane htmlView = new JScrollPane(htmlPane);

        //Add the scroll panes to a split pane.
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setTopComponent(treeView);
        splitPane.setBottomComponent(htmlView);
        splitPane.setDividerLocation(128);
        add(splitPane, BorderLayout.CENTER);
    }

    /** Required by TreeSelectionListener interface. */
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                           tree.getLastSelectedPathComponent();

        if (node == null) return;

        Object nodeInfo = node.getUserObject();
        if (node.isLeaf()) {
            moduleComponentInfo moduleComponent = (moduleComponentInfo)nodeInfo;
            displayURL(moduleComponent.moduleComponentURL);
            if (DEBUG) {
                System.out.print(moduleComponent.moduleComponentURL + ":  \n    ");
            }
        } else {
            displayURL(helpURL); 
        }
        if (DEBUG) {
            System.out.println(nodeInfo.toString());
        }
    }

    private class moduleComponentInfo {
        public String moduleComponentName;
        public URL moduleComponentURL;

        public moduleComponentInfo(String moduleComponent, String filename) {
            moduleComponentName = moduleComponent;
            moduleComponentURL = XMSSmodules.class.getResource(filename);
            if (moduleComponentURL == null) {
                System.err.println("Couldn't find file: "
                                   + filename);
            }
        }

        public String toString() {
            return moduleComponentName;
        }
    }

    private void initHelp() {
        String s = "object_preview.html";
        helpURL = XMSSmodules.class.getResource(s);
        if (helpURL == null) {
            System.err.println("Couldn't open help file: " + s);
        } else if (DEBUG) {
            System.out.println("Help URL is " + helpURL);
        }

        displayURL(helpURL);
    }

    private void displayURL(URL url) {
        try {
            if (url != null) {
                htmlPane.setPage(url);
            } else { //null url
		htmlPane.setText("check code !!!");
                if (DEBUG) {
                    System.out.println("Attempted to display a null URL.");
                }
            }
        } catch (IOException e) {
            System.err.println("Attempted to read a bad URL: " + url);
        }
    }

    private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode moduleCategory = null;
        DefaultMutableTreeNode moduleComponent = null;

     
         moduleCategory = new DefaultMutableTreeNode("XMSS Views");
        top.add(moduleCategory);

     
        moduleComponent = new DefaultMutableTreeNode(new moduleComponentInfo
            ("XMSS Main Map",
            "xmss_main_map.html"));
        moduleCategory.add(moduleComponent);

 
        moduleComponent = new DefaultMutableTreeNode(new moduleComponentInfo
            ("XMSS Department View",
            "xmss_department_view.html"));
        moduleCategory.add(moduleComponent);

     
        moduleComponent = new DefaultMutableTreeNode(new moduleComponentInfo
            ("XMSS Extern View",
            "xmss_extern_view.html"));
        moduleCategory.add(moduleComponent);

  
        moduleCategory.add(moduleComponent);
		
     

        moduleCategory = new DefaultMutableTreeNode("Reports");
        top.add(moduleCategory);

       
        moduleComponent = new DefaultMutableTreeNode(new moduleComponentInfo
            ("AlleWochenberichte2005.xls",
             "excel_preview_1.html"));
        moduleCategory.add(moduleComponent);

    
        moduleComponent = new DefaultMutableTreeNode(new moduleComponentInfo
            ("KennzahlenVertriebNov2005.xls",
             "excel_preview_2.html"));
        moduleCategory.add(moduleComponent);
        
           moduleCategory = new DefaultMutableTreeNode("Multimedia- und Hypermedia-Dateien");
        top.add(moduleCategory);

        moduleComponent = new DefaultMutableTreeNode(new moduleComponentInfo
            ("ConferenceSamplePart1.avi",
            "video_preview.html"));
        moduleCategory.add(moduleComponent);

     
        moduleComponent = new DefaultMutableTreeNode(new moduleComponentInfo
            ("ProjectPresentationA12.ppt",
            "pp_preview_a12.html"));
        moduleCategory.add(moduleComponent);

        moduleComponent = new DefaultMutableTreeNode(new moduleComponentInfo
            ("VectorPresentationApplet.xhtml",
            "vector_presentation_applet.html"));
        moduleCategory.add(moduleComponent);


        moduleComponent = new DefaultMutableTreeNode(new moduleComponentInfo
            ("UnserKennzahlensytem.doc",
	     "doc_viewer.html"));
        moduleCategory.add(moduleComponent);
		
		moduleCategory = new DefaultMutableTreeNode("Avatare");
        top.add(moduleCategory);


        moduleComponent = new DefaultMutableTreeNode(new moduleComponentInfo
            ("Avatar Settings",
             "avatar_settings.html"));
        moduleCategory.add(moduleComponent);
		
	
        moduleComponent = new DefaultMutableTreeNode(new moduleComponentInfo
            ("ReportAgent",
             "report_agent.html"));
        moduleCategory.add(moduleComponent);

        
        moduleComponent = new DefaultMutableTreeNode(new moduleComponentInfo
            ("Simulation Agent",
             "simulation_agent.html"));
        moduleCategory.add(moduleComponent);

        moduleComponent = new DefaultMutableTreeNode(new moduleComponentInfo
            ("Conference Agent",
             "conference_agent.html"));
        moduleCategory.add(moduleComponent);
		
		
		moduleCategory = new DefaultMutableTreeNode("OLAP_Module");
        top.add(moduleCategory);

        moduleComponent = new DefaultMutableTreeNode(new moduleComponentInfo
            ("OLAP-Cube Settings",
             "olap_settings.html"));
        moduleCategory.add(moduleComponent);


        moduleComponent = new DefaultMutableTreeNode(new moduleComponentInfo
            ("Olap-Cube Viewer",
             "olap_viewer.html"));
        moduleCategory.add(moduleComponent);
		
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = XMSSmodules.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

}
