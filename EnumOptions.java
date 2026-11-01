public enum EnumOptions {
   a("options.music", true, false),
   b("options.sound", true, false),
   c("options.invertMouse", false, true),
   d("options.sensitivity", true, false),
   e("options.fov", true, false),
   f("options.gamma", true, false),
   g("options.renderDistance", false, false),
   h("options.viewBobbing", false, true),
   i("options.anaglyph", false, true),
   j("options.advancedOpengl", false, true),
   k("options.framerateLimit", false, false),
   l("options.difficulty", false, false),
   m("options.graphics", false, false),
   n("options.GenLayerHills", false, true),
   o("options.guiScale", false, false),
   p("options.renderClouds", false, true),
   q("options.particles", false, false),
   STRIPELANDSFIX("options.stripeLandsFix", false, true);

   private final boolean r;
   private final boolean s;
   private final String t;

   public static EnumOptions a(int par0) {
      for (EnumOptions enumoptions : values()) {
         if (enumoptions.c() == par0) {
            return enumoptions;
         }
      }

      return null;
   }

   EnumOptions(String par3Str, boolean par4, boolean par5) {
      this.t = par3Str;
      this.r = par4;
      this.s = par5;
   }

   public boolean a() {
      return this.r;
   }

   public boolean b() {
      return this.s;
   }

   public int c() {
      return this.ordinal();
   }

   public String d() {
      return this.t;
   }
}
