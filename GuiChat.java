import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class GuiChat extends vp {
   private String b = "";
   private int c = -1;
   private boolean d = false;
   private String e = "";
   private String f = "";
   private int h = 0;
   private List i = new ArrayList();
   private URI j = null;
   protected agu a;
   private String k = "";

   public GuiChat() {
   }

   public GuiChat(String par1Str) {
      this.k = par1Str;
   }

   public void c() {
      Keyboard.enableRepeatEvents(true);
      this.c = this.p.w.c().size();
      this.a = new agu(this.u, 4, this.r - 12, this.q - 4, 12);
      this.a.f(100);
      this.a.a(false);
      this.a.b(true);
      this.a.a(this.k);
      this.a.c(false);
   }

   public void e() {
      Keyboard.enableRepeatEvents(false);
      this.p.w.d();
   }

   public void a() {
      this.a.a();
   }

   protected void a(char par1, int par2) {
      if (par2 == 15) {
         this.d();
      } else {
         this.d = false;
      }

      if (par2 == 1) {
         this.p.a((vp)null);
      } else if (par2 == 28) {
         String s = this.a.b().trim();
         this.p.w.addChatMessageInternal(s);
         if (s.length() > 0) {
            if (this.p.c(s)) {
               this.handleCommands(s);
            } else {
               this.p.h.a(s);
            }
         }

         this.p.a((vp)null);
      } else if (par2 == 200) {
         this.a(-1);
      } else if (par2 == 208) {
         this.a(1);
      } else if (par2 == 201) {
         this.p.w.a(19);
      } else if (par2 == 209) {
         this.p.w.a(-19);
      } else {
         this.a.a(par1, par2);
      }
   }

   public void handleCommands(String s) {
      adn stringtranslate = adn.a();
      if (s.startsWith("/tp ")) {
         String[] playerPos = s.split(" ");
         if (playerPos.length == 4) {
            this.p.h.teleportPlayer(playerPos[1], playerPos[2], playerPos[3]);
         } else {
            this.p.h.a("Incorrect syntax. Syntax should be \"/tp\" followed by 3 numbers.");
         }
      } else if (s.equals("/clear")) {
         this.p.f.clearWeatherViaCommand();
      } else if (s.equals("/rain")) {
         this.p.f.handleWeatherCommand();
      } else if (s.equals("/day")) {
         this.p.f.a(0L);
      } else if (s.startsWith("/flySpeed")) {
         String[] tempSpeed = s.split(" ");
         if (tempSpeed.length == 1) {
            this.p.h.a("Current flying speed: " + this.p.h.flySpeed);
         } else if (tempSpeed.length == 2) {
            int temporary = 1;
            boolean canContinue = true;

            try {
               temporary = Integer.parseInt(tempSpeed[1]);
            } catch (NumberFormatException ex) {
               canContinue = false;
               this.p.h.a("Unrecognized number input.");
            }

            if (canContinue) {
               this.p.h.setPlayerFlySpeed(temporary);
            }
         } else {
            this.p.h.a("Incorrect Syntax. Should be \"/flySpeed\" followed by a speed number.");
         }
      } else if (s.equals("/getMetadata")) {
         int thisBlockMetadata = this.p.f.getBlockMetadata(this.p.z.b, this.p.z.c, this.p.z.d);
         this.p.h.a("This block's metadata: " + thisBlockMetadata);
      } else if (s.startsWith("/setMetadata")) {
         String[] sArray = s.split(" ");
         if (sArray.length < 2) {
            this.p.h.a("You can't set a metadata WorldGenTallGrass null you dumbass!");
            return;
         }

         int metadata = 0;

         try {
            metadata = Integer.parseInt(sArray[1]);
         } catch (NumberFormatException ex) {
            this.p.h.a("Metadata MUST be a number!!! NO EXCEPTIONS!!!!!!!!!!!!");
            return;
         }

         if (metadata < 0 || metadata > 15) {
            this.p.h.a("Block metadata MUST be between 0 and 15 inclusive. NO EXCEPTIONS!!!!!!!");
            return;
         }

         int thisBlock = this.p.f.getBlockId(this.p.z.b, this.p.z.c, this.p.z.d);
         this.p.f.setBlockMetadataWithNotify(this.p.z.b, this.p.z.c, this.p.z.d, metadata);
         this.p.h.a("Set this block's metadata WorldGenTallGrass " + metadata);
      } else if (s.startsWith("/stemColor")) {
         String[] sArray = s.split(" ");
         if (sArray.length < 2) {
            this.p.h.a("You need WorldGenTallGrass actually input a stem metadata value!");
            return;
         }

         int metadata = 0;

         try {
            metadata = Integer.parseInt(sArray[1]);
         } catch (NumberFormatException ex) {
            this.p.h.a("Metadata MUST be a number!!! NO EXCEPTIONS!!!!!!!!!!!!");
            return;
         }

         int i = metadata * 32;
         int j = 255 - metadata * 8;
         int k = metadata * 4;
         int theColor = i << 16 | j << 8 | k;
         int redNum = theColor >> 16 & 0xFF;
         int greenNum = theColor >> 8 & 0xFF;
         int blueNum = theColor & 0xFF;
         this.p.h.a("Metadata: " + metadata + ", Red: " + redNum + ", Green: " + greenNum + ", Blue: " + blueNum);
      } else {
         this.p.h.a("Unrecognized command.");
      }
   }

   public void f() {
      super.f();
      int i = Mouse.getEventDWheel();
      if (i != 0) {
         if (i > 1) {
            i = 1;
         }

         if (i < -1) {
            i = -1;
         }

         if (!m()) {
            i *= 7;
         }

         this.p.w.a(i);
      }
   }

   protected void a(int par1, int par2, int par3) {
      if (par3 == 0) {
         dx chatclickdata = this.p.w.a(Mouse.getX(), Mouse.getY());
         if (chatclickdata != null) {
            URI uri = chatclickdata.b();
            if (uri != null) {
               this.j = uri;
               this.p.a(new be(this, this, chatclickdata.a(), 0, chatclickdata));
               return;
            }
         }
      }

      this.a.a(par1, par2, par3);
      super.a(par1, par2, par3);
   }

   public void a(boolean par1, int par2) {
      if (par2 == 0) {
         if (par1) {
            try {
               Class class1 = Class.forName("java.awt.Desktop");
               Object obj = class1.getMethod("getDesktop").invoke(null);
               class1.getMethod("browse", URI.class).invoke(obj, this.j);
            } catch (Throwable throwable) {
               throwable.printStackTrace();
            }
         }

         this.j = null;
         this.p.a(this);
      }
   }

   public void d() {
      if (this.p.l()) {
         if (this.d) {
            this.a.a(-1);
            if (this.h >= this.i.size()) {
               this.h = 0;
            }
         } else {
            int i = this.a.c(-1);
            if (this.a.h() - i < 1) {
               return;
            }

            this.i.clear();
            this.e = this.a.b().substring(i);
            this.f = this.e.toLowerCase();

            for (ah guiplayerinfo : ((EntityClientPlayerMP)this.p.h).cl.c) {
               if (guiplayerinfo.a(this.f)) {
                  this.i.add(guiplayerinfo);
               }
            }

            if (this.i.size() == 0) {
               return;
            }

            this.d = true;
            this.h = 0;
            this.a.b(i - this.a.h());
         }

         if (this.i.size() > 1) {
            StringBuilder stringbuilder = new StringBuilder();

            for (ah guiplayerinfo1 : this.i) {
               if (stringbuilder.length() > 0) {
                  stringbuilder.append(", ");
               }

               stringbuilder.append(guiplayerinfo1.a);
            }

            this.p.w.a(stringbuilder.toString());
         }

         this.a.b(((ah)this.i.get(this.h++)).a);
      }
   }

   public void a(int par1) {
      int i = this.c + par1;
      int j = this.p.w.c().size();
      if (i < 0) {
         i = 0;
      }

      if (i > j) {
         i = j;
      }

      if (i != this.c) {
         if (i == j) {
            this.c = j;
            this.a.a(this.b);
         } else {
            if (this.c == j) {
               this.b = this.a.b();
            }

            this.a.a((String)this.p.w.c().get(i));
            this.c = i;
         }
      }
   }

   public void a(int par1, int par2, float par3) {
      a(2, this.r - 14, this.q - 2, this.r - 2, Integer.MIN_VALUE);
      this.a.f();
      super.a(par1, par2, par3);
   }
}
