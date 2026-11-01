public class GuiVideoSettings extends vp {
   private vp b;
   protected String a = "Video Settings";
   private GameSettings c;
   private boolean d = false;
   private static EnumOptions[] e = new EnumOptions[]{EnumOptions.m, EnumOptions.g, EnumOptions.n, EnumOptions.k, EnumOptions.i, EnumOptions.h, EnumOptions.o, EnumOptions.j, EnumOptions.f, EnumOptions.p, EnumOptions.q, EnumOptions.STRIPELANDSFIX};

   public GuiVideoSettings(vp par1GuiScreen, GameSettings par2GameSettings) {
      this.b = par1GuiScreen;
      this.c = par2GameSettings;
   }

   public void c() {
      adn stringtranslate = adn.a();
      this.a = stringtranslate.b("options.videoTitle");
      int i = 0;
      Object[] aobj = e;
      int j = aobj.length;

      for (int k = 0; k < j; k++) {
         EnumOptions enumoptions = (EnumOptions)aobj[k];
         if (!enumoptions.a()) {
            this.s.add(new z(enumoptions.c(), this.q / 2 - 155 + i % 2 * 160, this.r / 6 + 24 * (i >> 1), enumoptions, this.c.c(enumoptions)));
         } else {
            this.s
               .add(
                  new ajz(
                     enumoptions.c(), this.q / 2 - 155 + i % 2 * 160, this.r / 6 + 24 * (i >> 1), enumoptions, this.c.c(enumoptions), this.c.a(enumoptions)
                  )
               );
         }

         i++;
      }

      this.s.add(new abp(200, this.q / 2 - 100, this.r / 6 + 168, stringtranslate.b("gui.done")));
      this.d = false;
      aobj = new String[]{"sun.arch.data.model", "com.ibm.vm.bitmode", "ContainerCreative.arch"};

      for (String s : (String[])aobj) {
         String s1 = System.getProperty(s);
         if (s1 != null && s1.indexOf("64") >= 0) {
            this.d = true;
            break;
         }
      }
   }

   protected void a(abp par1GuiButton) {
      if (par1GuiButton.h) {
         int i = this.c.P;
         if (par1GuiButton.f < 100 && par1GuiButton instanceof z) {
            this.c.a(((z)par1GuiButton).a(), 1);
            par1GuiButton.e = this.c.c(EnumOptions.a(par1GuiButton.f));
         }

         if (par1GuiButton.f == 200) {
            this.p.A.b();
            this.p.a(this.b);
         }

         if (this.c.P != i) {
            agd scaledresolution = new agd(this.p.A, this.p.d, this.p.e);
            int j = scaledresolution.a();
            int k = scaledresolution.b();
            this.a(this.p, j, k);
         }
      }
   }

   public void a(int par1, int par2, float par3) {
      this.k();
      this.a(this.u, this.a, this.q / 2, 20, 16777215);
      if (!this.d && this.c.e == 0) {
         this.a(this.u, cy.a("options.farWarning1"), this.q / 2, this.r / 6 + 144, 11468800);
         this.a(this.u, cy.a("options.farWarning2"), this.q / 2, this.r / 6 + 144 + 12, 11468800);
      }

      super.a(par1, par2, par3);
   }
}
